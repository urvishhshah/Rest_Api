/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.paf.assignment.dto;

import lombok.Data;

/**
 *
 * @author urvis
 */
@Data
public class JwtAuthenticationResponse {
    
    private String token;
    
    private String refreshToken;
    
}
