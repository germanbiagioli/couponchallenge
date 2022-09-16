/**
 * 
 */
package com.meli.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meli.challenge.security.config.TokenProvider;
import com.meli.challenge.security.entity.JwtResponse;
import com.meli.challenge.security.entity.UserDTO;

/**
 * @author german
 *
 */
@RestController
@RequestMapping("/login")
public class LoginController {
	 @Autowired
     AuthenticationManager authenticationManager;
     @Autowired
     TokenProvider tokenProvider;
     
     @PostMapping("/auth")
     public ResponseEntity<JwtResponse> authenticateUser(@RequestBody UserDTO login) {
         Authentication authentication = authenticationManager
             .authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
         SecurityContextHolder.getContext().setAuthentication(authentication);
         String jwt = tokenProvider.generateToken(authentication);
         return ResponseEntity.ok(new JwtResponse(jwt));
     }
}
