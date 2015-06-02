package com.sep.model;
// default package

/**
 * PermInstance entity. @author MyEclipse Persistence Tools
 */

public class PermInstance implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 5217441897592911949L;
	private Long id;
	private Long permissionId;
	private Long roleId;

	// Constructors

	/** default constructor */
	public PermInstance() {
	}

	/** full constructor */
	public PermInstance(Long permissionId, Long roleId) {
		this.permissionId = permissionId;
		this.roleId = roleId;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPermissionId() {
		return this.permissionId;
	}

	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}

	public Long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

}