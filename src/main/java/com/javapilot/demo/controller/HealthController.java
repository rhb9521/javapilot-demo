package com.javapilot.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HealthController {

    @GetMapping("/api/health")
    public Map<String, String> health() {
        return Map.of("status", "UP", "service", "javapilot-demo1");
    }

    @GetMapping("/api/health")
    public Map<String, String> health(Integer integer) {
        return Map.of("status", "UP", "service", "javapilot-demo");
    }
}
