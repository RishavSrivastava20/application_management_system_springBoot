package com.example.application_management_system.service;

import com.example.application_management_system.entity.Applicant;
import com.example.application_management_system.entity.Application;
import com.example.application_management_system.repositories.ApplicantJpaRepository;
import com.example.application_management_system.repositories.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicationService {

    @Autowired
    private ApplicantJpaRepository applicantJpaRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    public Application saveApplication(Long applicantId, Application application){
        Optional<Applicant> applicantOptional = applicantJpaRepository.findById(applicantId);
        if(applicantOptional.isPresent()){
            Applicant applicant = applicantOptional.get();
            application.setApplicant(applicant);
            return applicationRepository.save(application);
        }else {
            throw new RuntimeException("Applicant not found with id: " + applicantId);
        }
    }
}
