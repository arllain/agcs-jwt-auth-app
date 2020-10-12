package com.arllain.agcsjwtauthapp.services.exception;

public class AuthenticationCustomException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	/**
	 * @param message
	 */
	public AuthenticationCustomException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public AuthenticationCustomException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
