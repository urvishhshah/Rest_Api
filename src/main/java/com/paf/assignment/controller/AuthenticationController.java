/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.paf.assignment.controller;

import com.paf.assignment.dto.JwtAuthenticationResponse;
import com.paf.assignment.dto.RefreshTokenRequest;
import com.paf.assignment.dto.SignInRequest;
import com.paf.assignment.dto.SignUpRequest;
import com.paf.assignment.entities.User;
import com.paf.assignment.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author urvis
 */
@RestController                         
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor 
public class AuthenticationController {
    
    private final AuthenticationService authenticationService ;
    
    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(authenticationService.signup(signUpRequest));
        
    }
    
    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SignInRequest signInRequest){
        return ResponseEntity.ok(authenticationService.signin(signInRequest));
        
    }
    
    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthenticationResponse> refresh(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return ResponseEntity.ok(authenticationService.refreshToken(refreshTokenRequest));
        
    }
    
}
