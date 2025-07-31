package com.rays.form;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.StoreDTO;

/**
 * @author ankit
 *
 */
public class StoreForm extends BaseForm {

	@NotEmpty(message = "Please enter Product Name")
	@Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Only alphabets are allowed")
	private String product;

	@PastOrPresent(message = "Date must be today or in the past")
	@NotNull(message = "Please enter Date")
	private Date date;

	@NotEmpty(message = "Please select Mode")
	private String mode;

	@NotNull(message = "Please enter Price")
	@Min(value = 10000, message = " number must contain 10 digits")
	private Long price;

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	@Override
	public BaseDTO getDto() {
		StoreDTO dto = initDTO(new StoreDTO());
		dto.setDate(date);
		dto.setProduct(product);
		dto.setPrice(price);
		dto.setMode(mode);
		return dto;
	}
}