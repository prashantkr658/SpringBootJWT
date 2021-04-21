package com.spring.security.jwtbasic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.jwtbasic.jwtutils.JwtRequestModel;
import com.spring.security.jwtbasic.jwtutils.JwtResponseModel;
import com.spring.security.jwtbasic.jwtutils.JwtUserDetailsService;
import com.spring.security.jwtbasic.jwtutils.TokenManager;

@RestController
@CrossOrigin
public class JwtController {
	
	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenManager tokenManager;
	
	@PostMapping("/login")
	public ResponseEntity<JwtResponseModel> createToken(@RequestBody JwtRequestModel request) throws Exception{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		}catch(DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		}catch(BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIAL", e);
		}
		final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
		final String jwtToken = tokenManager.generateJwtToken(userDetails);
		
		return ResponseEntity.ok(new JwtResponseModel(jwtToken));
	}

}