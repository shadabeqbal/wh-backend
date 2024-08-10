package com.example.wh_backend.controllers;

import com.google.gson.Gson;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)

public class HealthCheck {

    @RequestMapping(method = RequestMethod.GET,value = "healthcheck")
    public ResponseEntity<?> healthCheck() { return ResponseEntity.ok(new Gson().toJson("Healthy")); }
}
