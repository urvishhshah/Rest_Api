/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.paf.assignment.services.impl;

import com.paf.assignment.dto.JwtAuthenticationResponse;
import com.paf.assignment.dto.RefreshTokenRequest;
import com.paf.assignment.dto.SignInRequest;
import com.paf.assignment.dto.SignUpRequest;
import com.paf.assignment.entities.Role;
import com.paf.assignment.entities.User;
import com.paf.assignment.repository.UserRepository;
import com.paf.assignment.services.AuthenticationService;
import com.paf.assignment.services.JWTService;
import java.util.HashMap;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author urvis
 */

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService{
    
    private final UserRepository userRepository;
    
    private final PasswordEncoder passwordEncoder;
    
    private final AuthenticationManager authenticationManager;
    
    private final JWTService jwtService;
    
    public User signup(SignUpRequest signUpRequest){
        
        User user = new User();
        
        user.setEmail(signUpRequest.getEmail());
        user.setFirstname(signUpRequest.getFirstName());
        user.setSecondname(signUpRequest.getLastName());
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        
        return userRepository.save(user);   
        
    }
    
    public JwtAuthenticationResponse signin(SignInRequest signInRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getEmail(), signInRequest.getPassword()));
        
        var user = userRepository.findByEmail(signInRequest.getEmail()).orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
       
        var jwt = jwtService.generateToken(user);
        
        var refreshToken = jwtService.generateRefreshToken(new HashMap<>(), user);
        
        JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();
        
        jwtAuthenticationResponse.setToken(jwt);
        jwtAuthenticationResponse.setRefreshToken(refreshToken);
        
        return jwtAuthenticationResponse;
        
    }
    
    public JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest){
        String userEmail = jwtService.extractUserName(refreshTokenRequest.getToken());
        User user = userRepository.findByEmail(userEmail).orElseThrow();
        if(jwtService.isTokenValid(refreshTokenRequest.getToken(),user)){
           var jwt = jwtService.generateToken(user);
           
        JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();
        
        jwtAuthenticationResponse.setToken(jwt);
        jwtAuthenticationResponse.setRefreshToken(refreshTokenRequest.getToken());
        
        return jwtAuthenticationResponse;
        }
        
        return null;
    }
    
    
}
