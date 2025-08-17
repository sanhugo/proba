package ru.proba.writings.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class TimezoneLoader {
    public List<Map<String, String>> loadTimezones() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream is = new ClassPathResource("json/russian_timezones.json").getInputStream()) {
            return mapper.readValue(is, new TypeReference<>() {});
        }
    }
}
