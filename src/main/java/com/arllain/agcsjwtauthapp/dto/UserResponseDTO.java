package com.arllain.agcsjwtauthapp.dto;

import java.time.Instant;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class UserResponseDTO {

	@ApiModelProperty(position = 0)
	private String firstName;

	@ApiModelProperty(position = 1)
	private String lastName;

	@ApiModelProperty(position = 2)
	private String email;

	@ApiModelProperty(position = 3)
	List<TelephoneDataDTO> phones;

	@ApiModelProperty(position = 4)
	private Instant created_at;

	@ApiModelProperty(position = 5)
	private Instant last_login;

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

	/**
	 * @return the created_at
	 */
	public Instant getCreated_at() {
		return created_at;
	}

	/**
	 * @param created_at the created_at to set
	 */
	public void setCreated_at(Instant created_at) {
		this.created_at = created_at;
	}

	/**
	 * @return the last_login
	 */
	public Instant getLast_login() {
		return last_login;
	}

	/**
	 * @param last_login the last_login to set
	 */
	public void setLast_login(Instant last_login) {
		this.last_login = last_login;
	}

}
