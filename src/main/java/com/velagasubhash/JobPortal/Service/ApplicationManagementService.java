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


        String email = application.getUser().getEmail();
        String jobTitle = application.getJob().getTitle();
        application.setApplicationStatus(status);
        JobApplication update = jobApplicationRepository.save(application);
        try {
            if(status == ApplicationStatus.HIRED){
                mailService.sendApprovalMail(email,jobTitle);
            }else if(status == ApplicationStatus.SHORTLISTED){
                mailService.sendInProcessMail(email,jobTitle);
            }else if(status == ApplicationStatus.REJECTED){
                mailService.sendRejectedMail(email,jobTitle);
            }
        } catch (Exception e) {
            System.err.println("Email failed to send, but status was updated: " + e.getMessage());
        }
        
        return update;
    }

    public List<JobApplication> getApplicationByJob(Long jobId){
        return jobApplicationRepository.findByJobJobId(jobId);
    }

}
