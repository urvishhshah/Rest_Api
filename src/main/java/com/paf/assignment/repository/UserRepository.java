/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.paf.assignment.repository;

import com.paf.assignment.entities.Role;
import com.paf.assignment.entities.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author urvis
 */

@Repository
public interface UserRepository  extends JpaRepository<User, Long> { 

    Optional<User>findByEmail(String email);
    
    User findByRole(Role role);
    
    
}
