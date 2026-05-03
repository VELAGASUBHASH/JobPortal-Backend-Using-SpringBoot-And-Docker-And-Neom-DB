package com.velagasubhash.JobPortal.Service;

import com.velagasubhash.JobPortal.Model.Role;
import com.velagasubhash.JobPortal.Model.User;
import com.velagasubhash.JobPortal.Repo.UserRepository;
import com.velagasubhash.JobPortal.Utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository repository;
    private final PasswordEncoder encoder;
    private final MailService mailService;
    private final JwtUtils jwtUtils;

    public void register(String name,String email,String password){
        if(repository.findByEmail(email).isPresent()){
            throw new RuntimeException("User Is Already Exist Please Login");
        }
        User user = User.builder()
                .name(name)
                .email(email)
                .password(encoder.encode(password))
                .role(Role.USER)
                .isVerified(false)
                .build();

        repository.save(user);

        String token = jwtUtils.generateJWT(email);
        mailService.sentVerificationMail(email,token);
    }

    public String login(String email, String password){
        User user = repository.findByEmail(email)
                .orElseThrow();

        if(!encoder.matches(password, user.getPassword())){
            throw new RuntimeException("User Credentials Are Wrong");

        }
        if(!user.isVerified()){
            throw new RuntimeException("Please Verify Your Account");
        }

        return jwtUtils.generateJWT(email);
    }

    public void verify(String token){
        String email = jwtUtils.extractEmail(token);
        User user = repository.findByEmail(email).orElseThrow();
        user.setVerified(true);
        repository.save(user);
        mailService.sentWelcomeMail(email);

    }
}
