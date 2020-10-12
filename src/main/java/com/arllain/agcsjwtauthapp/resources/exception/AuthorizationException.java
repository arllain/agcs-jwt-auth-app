package com.arllain.agcsjwtauthapp.resources.exception;

public class AuthorizationException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	/**
	 * @param message
	 */
	public AuthorizationException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public AuthorizationException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
