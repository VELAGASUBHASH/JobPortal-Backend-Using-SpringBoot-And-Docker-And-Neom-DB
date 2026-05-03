package com.velagasubhash.JobPortal.Controller;

import com.velagasubhash.JobPortal.Model.Job;
import com.velagasubhash.JobPortal.Model.JobApplication;
import com.velagasubhash.JobPortal.Model.JobStatus;
import com.velagasubhash.JobPortal.Model.User;
import com.velagasubhash.JobPortal.Repo.JobRepository;
import com.velagasubhash.JobPortal.Service.JobApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final JobRepository jobRepository;
    private final JobApplicationService jobApplicationService;

    @GetMapping("/jobs")
    public List<Job> getJob(){
        return jobRepository.findByJobStatus(JobStatus.OPEN);
    }

    @PostMapping("/apply/{jobId}")
    public JobApplication applyJob(@PathVariable Long jobId, @AuthenticationPrincipal UserDetails userDetails){
        return jobApplicationService.applyJob(jobId,userDetails.getUsername());
    }

    @GetMapping("/application")
    public List<JobApplication> getMyApplication(@AuthenticationPrincipal UserDetails userDetails){
    return jobApplicationService.getUserApplications(userDetails.getUsername());
}
}
