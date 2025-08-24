package com.example.application_management_system.service;

import com.example.application_management_system.entity.Application;
import com.example.application_management_system.entity.Resume;
import com.example.application_management_system.repositories.ApplicantCrudRepository;
import com.example.application_management_system.repositories.ApplicantJpaRepository;
import com.example.application_management_system.repositories.ApplicantPagingAndSortingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.example.application_management_system.entity.Applicant;

import java.util.List;

@Service
public class ApplicantService {

    @Autowired
    private ApplicantCrudRepository applicantCrudRepository;
    @Autowired
    private ApplicantPagingAndSortingRepository applicantPagingAndSortingRepository;
    @Autowired
    private ApplicantJpaRepository applicantJpaRepository;

    public List<Applicant> getAllApplicants(){
        return applicantCrudRepository.findAll();
    }

    public List<Applicant> getApplicantByStatus(String status){
        return applicantJpaRepository.findByStatusOrderByNameAsc(status);
    }

    public List<Applicant> getApplicantsByPartialName(String name){
        return applicantJpaRepository.findApplicantsByPartialName(name);
    }

    public Applicant saveApplicationCrud(Applicant applicant){
        Resume resume = applicant.getResume();
        List<Application> applications = applicant.getApplications();
        if(resume != null){
            resume.setApplicant(applicant);
        }
        if(applications != null){
            for(Application application : applications){
                application.setApplicant(applicant);
            }
        }
        return applicantCrudRepository.save(applicant);
    }

    public Iterable<Applicant> getApplicantsWithPagination(int page, int size){
        return applicantPagingAndSortingRepository.findAll(PageRequest.of(page, size));
    }
}

