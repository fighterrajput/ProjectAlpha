package com.rays.form;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.PhoneDTO;

/**
 * @author ankit
 *
 */
public class PhoneForm extends BaseForm {

	@NotEmpty(message = "Please enter Model Name")
	@Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Only alphabets are allowed")
	private String modelName;

	@PastOrPresent(message = "launch date must be today or in the past")
	@NotNull(message = "Please enter launch date")
	private Date launchDate;

	@NotEmpty(message = "Please select OS")
	private String os;

	@NotNull(message = "Please enter price")
	@Min(value = 10000, message = " price must contain 5 digits")
	private Long price;


	public String getModelName() {
		return modelName;
	}


	public void setModelName(String modelName) {
		this.modelName = modelName;
	}





	public Date getLaunchDate() {
		return launchDate;
	}


	public void setLaunchDate(Date launchDate) {
		this.launchDate = launchDate;
	}


	public String getOs() {
		return os;
	}


	public void setOs(String os) {
		this.os = os;
	}


	public Long getPrice() {
		return price;
	}


	public void setPrice(Long price) {
		this.price = price;
	}


	@Override
	public BaseDTO getDto() {
		PhoneDTO dto = initDTO(new PhoneDTO());
		dto.setLaunchDate(launchDate);
		dto.setModelName(modelName);
		dto.setPrice(price);
		dto.setOs(os);
		return dto;
	}
}