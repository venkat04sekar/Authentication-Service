package com.payment.module.auth.service.api.controller;

import com.payment.module.auth.service.api.entity.AuthRequest;
import com.payment.module.auth.service.api.entity.User;
import com.payment.module.auth.service.api.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.web.bind.annotation.*;

@RestController
public class WelcomeController {
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String welcome(){
        return "Welcome";
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(),
                    authRequest.getPassword()));
        }
        catch (Exception exception){
            throw new Exception("Invalid User and Password");
        }
        return jwtUtil.generateToken(authRequest.getUserName());

    }




}
