/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.paf.assignment.services;

import java.util.Map;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author urvis
 */
public interface JWTService {
    
    String extractUserName(String token);
    
    String generateToken(UserDetails userDetails);
    
    boolean isTokenValid(String token, UserDetails userDetails);
    
    String generateRefreshToken(Map<String, Object> extraClaims, UserDetails userDetails);
    
}
