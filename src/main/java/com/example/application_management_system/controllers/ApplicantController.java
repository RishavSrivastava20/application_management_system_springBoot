package com.example.application_management_system.controllers;

import com.example.application_management_system.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.application_management_system.entity.Applicant;

import java.util.List;

@RestController
@RequestMapping("/api/applicants")
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    @GetMapping
    public List<Applicant> getAllApplicants(){
        return applicantService.getAllApplicants();
    }

    @GetMapping("/getByStatus")
    public List<Applicant> getApplicantByStatus(@RequestParam String status){
        return applicantService.getApplicantByStatus(status);
    }

    @GetMapping("/getByName")
    public List<Applicant> getApplicantsByPartialName(@RequestParam String name){
        return applicantService.getApplicantsByPartialName(name);
    }

    @PostMapping
    public Applicant saveApplicant(@RequestBody Applicant applicant){
        System.out.println("Reached Applicant Controller");
        return applicantService.saveApplicationCrud(applicant);
    }

    @GetMapping("/page")
    public Iterable<Applicant> getApplicantsWithPagination(@RequestParam int page, @RequestParam int size){
        return applicantService.getApplicantsWithPagination(page,size);
    }
}
