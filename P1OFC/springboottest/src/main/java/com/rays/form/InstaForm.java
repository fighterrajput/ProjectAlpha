package com.rays.form;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.InstaDTO;

/**
 * @author ankit
 *
 */
public class InstaForm extends BaseForm {

	@NotEmpty(message = "Please enter Name")
	@Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Only alphabets are allowed")
	private String name;

	@PastOrPresent(message = "Age must be today or in the past")
	@NotNull(message = "Please enter Age")
	private Date age;

	@NotEmpty(message = "Please select Gender")
	private String gender;

	@NotNull(message = "Please enter number")
	@Min(value = 10000, message = " number must contain 10 digits")
	private Long number;






	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public Date getAge() {
		return age;
	}




	public void setAge(Date age) {
		this.age = age;
	}




	public String getGender() {
		return gender;
	}




	public void setGender(String gender) {
		this.gender = gender;
	}




	public Long getNumber() {
		return number;
	}




	public void setNumber(Long number) {
		this.number = number;
	}




	@Override
	public BaseDTO getDto() {
		InstaDTO dto = initDTO(new InstaDTO());
		dto.setAge(age);
		dto.setName(name);
		dto.setNumber(number);
		dto.setGender(gender);
		return dto;
	}
}