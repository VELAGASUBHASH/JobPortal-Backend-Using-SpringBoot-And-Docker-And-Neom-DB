package com.velagasubhash.JobPortal.Controller;

import com.velagasubhash.JobPortal.Model.ApplicationStatus;
import com.velagasubhash.JobPortal.Model.JobApplication;
import com.velagasubhash.JobPortal.Service.ApplicationManagementService;
import com.velagasubhash.JobPortal.Service.JobApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/Application")
@RequiredArgsConstructor
public class AdminApplicationController {
    private final ApplicationManagementService applicationManagementService;
    private final JobApplicationService jobApplicationService;

    @PutMapping("/{id}")
    public JobApplication updateStatus (@PathVariable Long id, @RequestParam ApplicationStatus status){
        return applicationManagementService.updateStatus(id,status);
    }

    @GetMapping("/job/{jobId}")
    public List<JobApplication> getByJob(@PathVariable Long jobId){
        return applicationManagementService.getApplicationByJob(jobId);
    }

    @GetMapping("/getAllApplication")
    public List<JobApplication> getAllApplications(@PathVariable Long id){
        return jobApplicationService.getAllUserApplications(id);
    }
}
