package com.velagasubhash.JobPortal.Controller;

import com.velagasubhash.JobPortal.Request.LoginRequest;
import com.velagasubhash.JobPortal.Request.RegisterRequest;
import com.velagasubhash.JobPortal.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request){
        authService.register(request.getName(),request.getEmail(),request.getPassword());
        return "Please Check Mail";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request){
        return authService.login(request.getEmail(),request.getPassword());
    }

    @GetMapping("/verify")
    public String verify(@RequestParam String token){
        authService.verify(token);
        return "Verified";
    }





}
