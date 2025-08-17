package ru.proba.writings.controller.api;

import org.springframework.web.bind.annotation.*;
import ru.proba.writings.DTO.building.BuildingAdditionDTO;
import ru.proba.writings.DTO.building.BuildingDTO;
import ru.proba.writings.DTO.building.BuildingIdDTO;
import ru.proba.writings.service.BuildingService;

import java.util.List;

@RestController
@RequestMapping("/api/buildings")
public class BuildingController {

    private final BuildingService buildingService;

    public BuildingController(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    @PostMapping("/add")
    public void add(@RequestBody BuildingAdditionDTO buildingDTO) {
        buildingService.save(buildingDTO);
    }
    @GetMapping
    public List<BuildingDTO> getBuildings(@RequestParam(required = false) Integer cityId) {
        if (cityId == null) {
            return buildingService.findAll();
        }
        return buildingService.findByCity(cityId);
    }

    @PostMapping("/deactivate")
    public void deactivate(@RequestBody BuildingIdDTO buildingId) {
        buildingService.blockBuilding(buildingId.getBuildingId());
    }

    @PostMapping("/activate")
    public void activate(@RequestBody BuildingIdDTO buildingId) {
        buildingService.activateBuilding(buildingId.getBuildingId());
    }
}
