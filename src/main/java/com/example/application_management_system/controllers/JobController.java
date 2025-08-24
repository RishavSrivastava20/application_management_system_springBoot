package com.example.application_management_system.controllers;

import com.example.application_management_system.entity.Job;
import com.example.application_management_system.entity.Applicant;
import com.example.application_management_system.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping
    public ResponseEntity<Job> createJob(@RequestBody Job job){
        Job createdJob = jobService.createJob(job);
        return ResponseEntity.ok(createdJob);
    }

    @PostMapping("/add-job-to-applicant")
    public ResponseEntity<Applicant> addJobToApplicant(@RequestParam Long applicantId, @RequestParam Long jobId){
        Applicant updatedApplicant = jobService.addJobToApplicant(applicantId, jobId);
        return ResponseEntity.ok(updatedApplicant);
    }
}
