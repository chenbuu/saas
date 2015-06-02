package com.sep.model;
// default package

import java.sql.Timestamp;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -445021010827052053L;
	private Long id;
	private Long saasId;
	private Integer status;
	private Timestamp createTime;
	private String userName;
	private String password;
	private String realName;
	private Long roleId;
	private String phone;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(Long saasId, Integer status, Timestamp createTime,
			String userName, String password, String realName, Long roleId,
			String phone) {
		this.saasId = saasId;
		this.status = status;
		this.createTime = createTime;
		this.userName = userName;
		this.password = password;
		this.realName = realName;
		this.roleId = roleId;
		this.phone = phone;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSaasId() {
		return this.saasId;
	}

	public void setSaasId(Long saasId) {
		this.saasId = saasId;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}