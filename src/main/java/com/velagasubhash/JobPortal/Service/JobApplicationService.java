package com.velagasubhash.JobPortal.Service;

import com.velagasubhash.JobPortal.Model.*;
import com.velagasubhash.JobPortal.Repo.JobApplicationRepository;
import com.velagasubhash.JobPortal.Repo.JobRepository;
import com.velagasubhash.JobPortal.Repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobApplicationService {
    private final JobRepository jobRepository;
    private final JobApplicationRepository jobApplicationRepository;
    private final MailService mailService;
    private final UserRepository userRepository;


    public JobApplication applyJob(Long jobId, String email){
        User user = userRepository.findByEmail(email)
                .orElseThrow(()->new RuntimeException("User Not Found"));
        Job job = jobRepository.findById(jobId)
                .orElseThrow(()-> new RuntimeException("Job Not Found"));

        if(job.getJobStatus()!= JobStatus.OPEN){
            throw new RuntimeException("Job Is Not Avaliable Right Now");
        }

        JobApplication jobApplication = new JobApplication();
        jobApplication.setUser(user);
        jobApplication.setJob(job);
        jobApplication.setApplicationStatus(ApplicationStatus.APPLIED);
        jobApplication.setAppliedAt(LocalDateTime.now());

        JobApplication saved = jobApplicationRepository.save(jobApplication);

        mailService.sendApplicationReceviedMail(user.getEmail(),job.getTitle());

        return saved;
    }

    public List<JobApplication> getAllUserApplications(Long userId){
        return jobApplicationRepository.findByUserId(userId);
    }

    public List<JobApplication> getUserApplications(Long userId) {
        return jobApplicationRepository.findByUserId(userId);
    }
}
