package com.example.application_management_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.application_management_system.entity.Applicant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApplicantJpaRepository extends JpaRepository<Applicant,  Long> {
    List<Applicant> findByStatusOrderByNameAsc(String status);

    @Query("select a FROM Applicant a WHERE a.name like %:name%")
    List<Applicant> findApplicantsByPartialName(@Param("name") String name);
}
