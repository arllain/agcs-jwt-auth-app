package com.arllain.agcsjwtauthapp.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author arllain
 *
 */
@Entity
@Table(name = "tb_user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	@Size(max = 50, message = "Maximum first name length: 50 characters")
	private String firstName;

	@Column(nullable = false)
	@Size(max = 50, message = "Maximum last name length: 50 characters")
	private String lastName;

	@Column(unique = true, nullable = false)
	private String email;

	@JsonIgnore
	@Column(nullable = false)
	@Size(min = 4, message = "Minimum password length: 4 characters")
	private String password;

	private Instant created_at;

	private Instant last_login;

	@ElementCollection(fetch = FetchType.EAGER)
	private List<Telephone> phones = new ArrayList<>();

	public User() {

	}

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param password
	 * @param created_at
	 * @param last_login
	 * @param phones
	 */
	public User(Integer id, @Size(max = 50, message = "Maximum first name length: 50 characters") String firstName,
			@Size(max = 50, message = "Maximum last name length: 50 characters") String lastName, String email,
			@Size(min = 4, message = "Minimum password length: 4 characters") String password, Instant created_at,
			Instant last_login, List<Telephone> phones) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.created_at = created_at;
		this.last_login = last_login;
		this.phones = phones;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

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

	/**
	 * @return the phones
	 */
	public List<Telephone> getPhones() {
		return phones;
	}

	/**
	 * @param phones the phones to set
	 */
	public void setPhones(List<Telephone> phones) {
		this.phones = phones;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		User other = (User) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

}
