package com.example.application_management_system.service;

import com.example.application_management_system.entity.Job;
import com.example.application_management_system.repositories.ApplicantJpaRepository;
import com.example.application_management_system.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.application_management_system.entity.Applicant;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplicantJpaRepository applicantJpaRepository;

    public Job createJob(Job job){
        return jobRepository.save(job);
    }

    public Applicant addJobToApplicant(Long applicantId, Long jobId){
        Optional<Applicant> applicant = applicantJpaRepository.findById(applicantId);
        Optional<Job> job = jobRepository.findById(jobId);
        
        if(applicant.isPresent() && job.isPresent()){
            applicant.get().getJobs().add(job.get());
            applicantJpaRepository.save(applicant.get());
            return applicant.get();
        }else {
            throw new IllegalArgumentException("Applicant or job not found");
        }
    }


}
