package com.spring.security.jwtbasic.jwtutils;

import java.io.Serializable;

public class JwtResponseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -54313439672327596L;

	private final String token;
	
	public JwtResponseModel(String token) {
		this.token = token;
	}
	
	public String getToken() {
		return token;
	}
}
