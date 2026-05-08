// package com.velagasubhash.JobPortal.Service;

// import lombok.RequiredArgsConstructor;
// import org.springframework.mail.SimpleMailMessage;
// import org.springframework.mail.javamail.JavaMailSender;
// import org.springframework.stereotype.Service;

// @Service
// @RequiredArgsConstructor
// public class MailService {
//     private final JavaMailSender mailSender;

//     public void sentVerificationMail(String to, String token){
//         SimpleMailMessage message = new SimpleMailMessage();
//         message.setTo(to);
//         message.setFrom("velagasubhash03@gmail.com"); // Required by Brevo
//         message.setSubject("Verify Your Account");
//         message.setText("Click: https://jobportalbackend-celm.onrender.com/auth/verify?token=" + token);

//         mailSender.send(message);
//     }

//     public void sentWelcomeMail(String to){
//         SimpleMailMessage message = new SimpleMailMessage();
//         message.setTo(to);
//         message.setFrom("velagasubhash03@gmail.com"); // Required by Brevo
//         message.setSubject("Welcome To Our Job Platform");
//         message.setText("This Platform Will Shape Your Future And Helps In Getting A WonderFul Job");

//         mailSender.send(message);
//     }

//     public void sendApplicationReceviedMail(String to,String jobTitle){
//         SimpleMailMessage message = new SimpleMailMessage();
//         message.setTo(to);
//         message.setFrom("velagasubhash03@gmail.com"); // Required by Brevo
//         message.setSubject("We Recevied Your Application");
//         message.setText("Our Team Verify And Get Back As Soon As Possiable. Wish Good Future");

//         mailSender.send(message);
//     }

//     public void sendInProcessMail(String to,String jobTitle){
//         SimpleMailMessage message = new SimpleMailMessage();
//         message.setTo(to);
//         message.setFrom("velagasubhash03@gmail.com"); // Required by Brevo
//         message.setSubject("Your Application Is Process");
//         message.setText("Your Application Is In Process and Might Be Under Consideration . Cool Prepare For UpComing Rounds If You Select In ShortListing");

//         mailSender.send(message);
//     }

//     public void sendApprovalMail(String to,String jobTitle){
//         SimpleMailMessage message = new SimpleMailMessage();
//         message.setTo(to);
//         message.setFrom("velagasubhash03@gmail.com"); // Required by Brevo
//         message.setSubject("Your Application Is Approval");
//         message.setText("Your Application Is Approved and We Will Share Next Round Details In A While.");

//         mailSender.send(message);
//     }

//     public void sendRejectedMail(String to,String jobTitle){
//         SimpleMailMessage message = new SimpleMailMessage();
//         message.setTo(to);
//         message.setFrom("velagasubhash03@gmail.com"); // Required by Brevo
//         message.setSubject("Your Application Is Rejected");
//         message.setText("Your Application Is Rejected and We Are Going With Other Person With Better Skills. And We Believe That Your Will Placed In Future With Good Package ");

//         mailSender.send(message);
//     }
// }
package com.velagasubhash.JobPortal.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {
    private final JavaMailSender mailSender;

    public void sentVerificationMail(String to, String token){
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setFrom("velagasubhash03@gmail.com");
            message.setSubject("Verify Your Account");
            message.setText("Click: https://jobportalbackend-celm.onrender.com/auth/verify?token=" + token);
            mailSender.send(message);
        } catch (Exception e) {
            System.err.println("Failed to send Verification Mail: " + e.getMessage());
        }
    }

    public void sentWelcomeMail(String to){
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setFrom("velagasubhash03@gmail.com");
            message.setSubject("Welcome To Our Job Platform");
            message.setText("This Platform Will Shape Your Future And Helps In Getting A WonderFul Job");
            mailSender.send(message);
        } catch (Exception e) {
            System.err.println("Failed to send Welcome Mail: " + e.getMessage());
        }
    }

    public void sendApplicationReceviedMail(String to, String jobTitle){
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setFrom("velagasubhash03@gmail.com");
            message.setSubject("We Received Your Application: " + jobTitle);
            message.setText("Our Team will verify your profile and get back to you as soon as possible. Wishing you a good future!");
            mailSender.send(message);
        } catch (Exception e) {
            System.err.println("Failed to send Application Received Mail: " + e.getMessage());
        }
    }

    public void sendInProcessMail(String to, String jobTitle){
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setFrom("velagasubhash03@gmail.com");
            message.setSubject("Update: Your Application for " + jobTitle + " is Shortlisted!");
            message.setText("Congratulations! Your application is in process and under consideration. Please prepare for upcoming rounds.");
            mailSender.send(message);
        } catch (Exception e) {
            System.err.println("Failed to send In-Process Mail: " + e.getMessage());
        }
    }

    public void sendApprovalMail(String to, String jobTitle){
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setFrom("velagasubhash03@gmail.com");
            message.setSubject("Congratulations! You are Hired for " + jobTitle);
            message.setText("Your application is approved and you are hired! We will share the onboarding details shortly.");
            mailSender.send(message);
        } catch (Exception e) {
            System.err.println("Failed to send Approval Mail: " + e.getMessage());
        }
    }

    public void sendRejectedMail(String to, String jobTitle){
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setFrom("velagasubhash03@gmail.com");
            message.setSubject("Update on your application for " + jobTitle);
            message.setText("Unfortunately, we are moving forward with other candidates at this time. We believe you have great skills and wish you the best in your future endeavors.");
            mailSender.send(message);
        } catch (Exception e) {
            System.err.println("Failed to send Rejection Mail: " + e.getMessage());
        }
    }
}
