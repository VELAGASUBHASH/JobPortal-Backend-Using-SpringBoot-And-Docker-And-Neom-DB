package com.velagasubhash.JobPortal.Repo;

import com.velagasubhash.JobPortal.Model.Job;
import com.velagasubhash.JobPortal.Model.JobStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job,Long> {
    List<Job> findByJobStatus(JobStatus jobStatus);
}
