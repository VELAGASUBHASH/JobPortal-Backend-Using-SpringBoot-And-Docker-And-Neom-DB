package com.velagasubhash.JobPortal.Controller;

import com.velagasubhash.JobPortal.Model.Job;
import com.velagasubhash.JobPortal.Model.User;
import com.velagasubhash.JobPortal.Service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/job")
@RequiredArgsConstructor
public class AdminController {
    private final JobService jobService;

    @PostMapping("/createJob")
    public Job createjob(@RequestBody Job job, @AuthenticationPrincipal UserDetails user){
        return jobService.createJob(job,user.getUsername());
    }
    @PutMapping("/{id}")
    public Job updateJob(@PathVariable Long id,@RequestBody Job job){
        return jobService.updateJob(id,job);

    }

    @DeleteMapping("/{id}")
    public void deleteJob(@PathVariable Long id){
         jobService.deleteJob(id);
    }

    @GetMapping("/alljobs")
    public List<Job>getAllJobs(){
        return jobService.getAllJobs();
    }



}
