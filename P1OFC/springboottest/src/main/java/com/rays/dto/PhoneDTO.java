package com.rays.dto;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_phone")
public class PhoneDTO extends BaseDTO {

	@Column(name = "MODEL_NAME", length = 20)
	private String modelName;

	@Column(name = "OS", length = 20)
	private String os;

	@Column(name = "LAUNCH_DATE")
	private Date launchDate;

	@Column(name = "PRICE", length = 10)
	private Long price;

	@Column(name = "ORG_NAME", length = 50)
	private String orgName;

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}



	public Date getLaunchDate() {
		return launchDate;
	}

	public void setLaunchDate(Date launchDate) {
		this.launchDate = launchDate;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUniqueKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedHashMap<String, String> orderBY() {
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("modelName", "asc");
		return map;
	}

	@Override
	public LinkedHashMap<String, Object> uniqueKeys() {
		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("modifiedBy", modifiedBy);
		return map;
	}

	

}