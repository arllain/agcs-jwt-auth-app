package com.arllain.agcsjwtauthapp.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.arllain.agcsjwtauthapp.domain.Telephone;

import io.swagger.annotations.ApiModelProperty;

public class UserDataDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(position = 0)
	@NotEmpty(message = "First name is required")
	private String firstName;
	@ApiModelProperty(position = 1)
	@NotEmpty(message = "Last name is required")
	private String lastName;
	@ApiModelProperty(position = 2)
	@NotEmpty(message = "Email Address is required")
	@Email(message = "You must enter a valid email")
	private String email;
	@ApiModelProperty(position = 3)
	@NotEmpty(message = "Password is required")
	private String password;
	@ApiModelProperty(position = 4)
	@NotEmpty(message = "Telephone is required. You must enter at least one.")
	List<TelephoneDataDTO> phones;

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

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

	/**
	 * @return the phones
	 */
	public List<TelephoneDataDTO> getPhones() {
		return phones;
	}

	/**
	 * @param phones the phones to set
	 */
	public void setPhones(List<TelephoneDataDTO> phones) {
		this.phones = phones;
	}

}
