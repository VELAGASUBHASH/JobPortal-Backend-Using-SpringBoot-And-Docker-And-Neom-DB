package com.velagasubhash.JobPortal.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {
    private final JavaMailSender mailSender;

    public void sentVerificationMail(String to, String token){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Verify Your Account");
        message.setText("Click: https://jobportalbackend-celm.onrender.com/auth/verify?token=" + token);

        mailSender.send(message);
    }

    public void sentWelcomeMail(String to){

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject("Welcome To Our Job Platform");
            message.setText("This Platform Will Shape Your Future And Helps In Getting A WonderFul Job");

            mailSender.send(message);


    }


    public void sendApplicationReceviedMail(String to,String jobTitle){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("We Recevied Your Application");
        message.setText("Our Team Verify And Get Back As Soon As Possiable. Wish Good Future");

        mailSender.send(message);
    }

    public void sendInProcessMail(String to,String jobTitle){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Your Application Is Process");
        message.setText("Your Application Is In Process and Might Be Under Consideration . Cool Prepare For UpComing Rounds If You Select In ShortListing");

        mailSender.send(message);
    }

    public void sendApprovalMail(String to,String jobTitle){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Your Application Is Approval");
        message.setText("Your Application Is Approved and We Will Share Next Round Details In A While.");

        mailSender.send(message);
    }

    public void sendRejectedMail(String to,String jobTitle){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Your Application Is Rejected");
        message.setText("Your Application Is Rejected and We Are Going With Other Person With Better Skills. And We Believe That Your Will Placed In Future With Good Package ");

        mailSender.send(message);
    }
}
