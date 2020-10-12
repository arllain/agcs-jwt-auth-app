package com.arllain.agcsjwtauthapp.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author arllain
 *
 */
@Embeddable
public class Telephone implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	@NotEmpty
	private Integer number;

	@NotNull
	@NotEmpty
	private Integer area_code;

	@NotNull
	@NotEmpty
	private String country_code;

	public Telephone() {

	}

	/**
	 * @param number
	 * @param area_code
	 * @param country_code
	 */
	public Telephone(@NotNull @NotEmpty Integer number, @NotNull @NotEmpty Integer area_code,
			@NotNull @NotEmpty String country_code) {
		super();
		this.number = number;
		this.area_code = area_code;
		this.country_code = country_code;
	}

	/**
	 * @return the number
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}

	/**
	 * @return the area_code
	 */
	public Integer getArea_code() {
		return area_code;
	}

	/**
	 * @param area_code the area_code to set
	 */
	public void setArea_code(Integer area_code) {
		this.area_code = area_code;
	}

	/**
	 * @return the country_code
	 */
	public String getCountry_code() {
		return country_code;
	}

	/**
	 * @param country_code the country_code to set
	 */
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((area_code == null) ? 0 : area_code.hashCode());
		result = prime * result + ((country_code == null) ? 0 : country_code.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
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
		Telephone other = (Telephone) obj;
		if (area_code == null) {
			if (other.area_code != null) {
				return false;
			}
		} else if (!area_code.equals(other.area_code)) {
			return false;
		}
		if (country_code == null) {
			if (other.country_code != null) {
				return false;
			}
		} else if (!country_code.equals(other.country_code)) {
			return false;
		}
		if (number == null) {
			if (other.number != null) {
				return false;
			}
		} else if (!number.equals(other.number)) {
			return false;
		}
		return true;
	}

}
