package com.example.application_management_system.controllers;

import com.example.application_management_system.entity.Application;
import com.example.application_management_system.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping("{applicantId}")
    public ResponseEntity<Application> createApplication( @PathVariable Long applicantId, @RequestBody Application application){
        return ResponseEntity.ok(applicationService.saveApplication(applicantId, application));
    }
}
