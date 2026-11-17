package com.example.microservice;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

    private final JdbcTemplate jdbcTemplate;

    public DataController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/api/data")
    public Map<String, Object> getData() {
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(
            "SELECT id, name FROM sample_data ORDER BY id"
        );

        return Map.of(
            "status", "success",
            "message", "Data retrieved successfully",
            "data", rows
        );
    }

    @GetMapping("/api/health")
    public Map<String, String> health() {
        return Map.of("status", "UP");
    }
}
