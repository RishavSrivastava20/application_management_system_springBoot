package com.example.application_management_system.repositories;

import org.springframework.data.repository.ListPagingAndSortingRepository;
import com.example.application_management_system.entity.Applicant;

public interface ApplicantPagingAndSortingRepository extends ListPagingAndSortingRepository<Applicant, Long> {
}
