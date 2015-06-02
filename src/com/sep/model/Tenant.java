package com.sep.model;
// default package

import java.sql.Timestamp;

/**
 * Tenant entity. @author MyEclipse Persistence Tools
 */

public class Tenant implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -5803950324772542327L;
	private Long id;
	private Integer status;
	private String name;
	private String country;
	private String province;
	private String city;
	private String contactor;
	private String address;
	private String telephone;
	private String email;
	private String co;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public Tenant() {
	}

	/** full constructor */
	public Tenant(Integer status, String name, String country, String province,
			String city, String contactor, String address, String telephone,
			String email, String co, Timestamp createTime) {
		this.status = status;
		this.name = name;
		this.country = country;
		this.province = province;
		this.city = city;
		this.contactor = contactor;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
		this.co = co;
		this.createTime = createTime;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getContactor() {
		return this.contactor;
	}

	public void setContactor(String contactor) {
		this.contactor = contactor;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCo() {
		return this.co;
	}

	public void setCo(String co) {
		this.co = co;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}