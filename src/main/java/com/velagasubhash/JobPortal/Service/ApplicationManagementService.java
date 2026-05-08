package com.velagasubhash.JobPortal.Service;

import com.velagasubhash.JobPortal.Model.ApplicationStatus;
import com.velagasubhash.JobPortal.Model.JobApplication;
import com.velagasubhash.JobPortal.Repo.JobApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationManagementService {

    private final JobApplicationRepository jobApplicationRepository;
    private final MailService mailService;

    public JobApplication updateStatus(Long appId, ApplicationStatus status){
        JobApplication application = jobApplicationRepository.findById(appId)
                .orElseThrow(()-> new RuntimeException("No Application Found"));

        String email = (application.getUser() != null) ? application.getUser().getEmail() : null;
        String jobTitle = (application.getJob() != null) ? application.getJob().getTitle() : "a job";

        application.setApplicationStatus(status);
        JobApplication update = jobApplicationRepository.save(application);
        

        if (email != null) {
            if(status == ApplicationStatus.HIRED){
                mailService.sendApprovalMail(email, jobTitle);
            } else if(status == ApplicationStatus.SHORTLISTED){
                mailService.sendInProcessMail(email, jobTitle);
            } else if(status == ApplicationStatus.REJECTED){
                mailService.sendRejectedMail(email, jobTitle);
            }
        }
        
        return update;
    }

    public List<JobApplication> getApplicationByJob(Long jobId){
        return jobApplicationRepository.findByJobJobId(jobId);
    }
}
