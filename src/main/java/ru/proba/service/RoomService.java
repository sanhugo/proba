package ru.proba.service;

import org.springframework.stereotype.Service;
import ru.proba.repositories.RoomRepository;

@Service
public class RoomService {
    private final RoomRepository roomRepository;
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }
    public Long countActiveRoomsInBuilding(Long buildingId) {
        return roomRepository.countByBuilding_ActiveTrue(buildingId);
    }
}
