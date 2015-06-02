package com.sep.model;
// default package

/**
 * Dic entity. @author MyEclipse Persistence Tools
 */

public class Dic implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8406066972972745193L;
	private Long id;
	private Integer status;
	private String obj;
	private String attr;
	private String name;
	private Integer value;

	// Constructors

	/** default constructor */
	public Dic() {
	}

	/** full constructor */
	public Dic(Integer status, String obj, String attr, String name,
			Integer value) {
		this.status = status;
		this.obj = obj;
		this.attr = attr;
		this.name = name;
		this.value = value;
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

	public String getObj() {
		return this.obj;
	}

	public void setObj(String obj) {
		this.obj = obj;
	}

	public String getAttr() {
		return this.attr;
	}

	public void setAttr(String attr) {
		this.attr = attr;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getValue() {
		return this.value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

}