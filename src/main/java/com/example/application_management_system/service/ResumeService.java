package com.example.application_management_system.service;

import com.example.application_management_system.entity.Resume;
import com.example.application_management_system.entity.Applicant;
import com.example.application_management_system.repositories.ApplicantJpaRepository;
import com.example.application_management_system.repositories.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResumeService {

    @Autowired
    private ApplicantJpaRepository applicantJpaRepository;
    @Autowired
    private ResumeRepository resumeRepository;

    public Resume addResume(Long applicantId, Resume resume){
        Optional<Applicant> applicantOptional = applicantJpaRepository.findById(applicantId);
        if(applicantOptional.isPresent()){
            Applicant applicant = applicantOptional.get();
            resume.setApplicant(applicant);
            return resumeRepository.save(resume);
        }else {
            throw new RuntimeException("Applicant not found with id: " + applicantId);
        }
    }
}
