package com.example.application_management_system.repositories;

import com.example.application_management_system.entity.Applicant;
import org.springframework.data.repository.ListCrudRepository;

public interface ApplicantCrudRepository extends ListCrudRepository<Applicant, Long> {
}
