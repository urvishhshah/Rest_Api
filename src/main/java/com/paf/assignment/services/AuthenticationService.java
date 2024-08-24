/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.paf.assignment.services;

import com.paf.assignment.dto.JwtAuthenticationResponse;
import com.paf.assignment.dto.RefreshTokenRequest;
import com.paf.assignment.dto.SignInRequest;
import com.paf.assignment.dto.SignUpRequest;
import com.paf.assignment.entities.User;

/**
 *
 * @author urvis
 */
public interface AuthenticationService {
    
    User signup(SignUpRequest signUpRequest);
    
    JwtAuthenticationResponse signin(SignInRequest signInRequest);
    
    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
    
}
