package com.velagasubhash.JobPortal.Service;

import com.velagasubhash.JobPortal.Model.Job;

import com.velagasubhash.JobPortal.Model.JobStatus;
import com.velagasubhash.JobPortal.Model.Role;
import com.velagasubhash.JobPortal.Model.User;
import com.velagasubhash.JobPortal.Repo.JobRepository;
import com.velagasubhash.JobPortal.Repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobService {
    private final JobRepository jobRepository;
    private final UserRepository userRepository;

    public Job createJob(Job job,String email ){
        User user=userRepository.findByEmail(email)
                .orElseThrow(()-> new RuntimeException("User Not Found"));

        if (user.getRole()!= Role.ADMIN){
            throw new RuntimeException("Only Admin Can Add Jobs");
        }
        job.setCreatedBy(user);
        job.setJobStatus(JobStatus.OPEN);
        return jobRepository.save(job);
    }

    public Job updateJob(Long id,Job updatejob){
        Job job= jobRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Job Not Found"));

        job.setTitle(updatejob.getTitle());
        job.setDescription(updatejob.getDescription());
        job.setCompany(updatejob.getCompany());
        job.setLocation(updatejob.getLocation());
        job.setSalary(updatejob.getSalary());
        job.setJobStatus(updatejob.getJobStatus());

        return jobRepository.save(job);
    }

    public void deleteJob(Long id){
        jobRepository.deleteById(id);
    }

    public List<Job> getAllJobs(){
        return jobRepository.findAll();
    }




}
