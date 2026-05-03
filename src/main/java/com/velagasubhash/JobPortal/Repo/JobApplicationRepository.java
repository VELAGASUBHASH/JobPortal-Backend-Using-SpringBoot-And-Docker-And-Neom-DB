package com.velagasubhash.JobPortal.Repo;

import com.velagasubhash.JobPortal.Model.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication,Long> {
    List<JobApplication>findByUserId(Long userId);
//    List<JobApplication>findByJobId(Long jobId);
    List<JobApplication> findByJobJobId(Long jobId);
}
