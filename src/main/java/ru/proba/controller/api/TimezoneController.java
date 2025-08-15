package ru.proba.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.proba.config.TimezoneLoader;

import java.time.ZoneId;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/timezones")
public class TimezoneController {

    @GetMapping
    public List<Map<String, String>> getTimezones() throws Exception {
        return new TimezoneLoader().loadTimezones();
    }
}
