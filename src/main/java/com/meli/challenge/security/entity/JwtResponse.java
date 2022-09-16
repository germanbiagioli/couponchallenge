/**
 * 
 */
package com.meli.challenge.security.entity;

/**
 * @author german
 *
 */
public class JwtResponse {

 private String token;

public JwtResponse(String token) {
	super();
	this.token = token;
}

public void setToken(String token) {
	this.token = token;
}

public String getToken() {
	return token;
}
}
