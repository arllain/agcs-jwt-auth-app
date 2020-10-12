package com.arllain.agcsjwtauthapp.dto;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

public class TelephoneDataDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(position = 0)
	@NotEmpty(message = "Number is required")
	@Min(value = 8, message = "Number should not be less than 18")
	private Integer number;
	
	@ApiModelProperty(position = 1)
	@NotEmpty(message = "Area code is required")
	@Min(value = 2, message = "Area code should not be less than 18")
	@Max(value = 3, message = "Area code should not be greater than 3")
	private Integer area_code;
	
	@ApiModelProperty(position = 2)
	@NotEmpty(message = "Country code is required")
	@Size(min = 3, max = 3, message= "Country code must be 3 characters long")
	private String country_code;
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


}
