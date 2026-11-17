package com.javapilot.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class HealthController {

    @GetMapping("/api/health")
    public Map<String, String> health() {
        System.out.println("进入健康检查");
        List list=null;
        //test1
        list.add(1);
        list.add(2);
        return Map.of("status", "UP", "service", "javapilot-demo1");
    }

}




