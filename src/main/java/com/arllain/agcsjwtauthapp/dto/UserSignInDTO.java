package com.arllain.agcsjwtauthapp.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;

public class UserSignInDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(position = 0)
	@NotEmpty(message = "Email Address is required")
	@Email(message = "You must enter a valid email")
	private String email;
	@ApiModelProperty(position = 1)
	@NotEmpty(message = "Password is required")
	private String password;

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
