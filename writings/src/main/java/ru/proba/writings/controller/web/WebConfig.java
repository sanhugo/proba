package ru.proba.writings.controller.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WebConfig {
    @Bean
    public static RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
