package com.spring.security.jwtbasic.jwtutils;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtRequestModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1651787689791690771L;

	private String username;
	private String password;
}
