package ru.proba.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.util.List;

@RestController
@RequestMapping("/api/timezones")
public class TimezoneController {

    @GetMapping
    public List<String> getTimezones() {
        List<String> list = List.of("Europe/","Asia/");
        return ZoneId.getAvailableZoneIds()
                .stream()
                .filter(tz ->list.stream().anyMatch(tz::startsWith))
                .sorted()
                .toList();
    }
}
