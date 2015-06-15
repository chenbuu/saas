package com.sep.model;
// default package

import java.sql.Timestamp;

/**
 * News entity. @author MyEclipse Persistence Tools
 */

public class News implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -2761381953477961026L;
	private Long id;
	private Long saasId;
	private Integer status;
	private Timestamp createTime;
	private Integer navFirst;
	private Integer navSecond;
	private Long fileInfoId;
	private String title;
	private String content;

	// Constructors

	/** default constructor */
	public News() {
	}

	/** full constructor */
	public News(Long saasId, Integer status, Timestamp createTime,
			Integer navFirst, Integer navSecond, Long fileInfoId, String title,
			String content) {
		this.saasId = saasId;
		this.status = status;
		this.createTime = createTime;
		this.navFirst = navFirst;
		this.navSecond = navSecond;
		this.fileInfoId = fileInfoId;
		this.title = title;
		this.content = content;
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

	public Integer getNavFirst() {
		return this.navFirst;
	}

	public void setNavFirst(Integer navFirst) {
		this.navFirst = navFirst;
	}

	public Integer getNavSecond() {
		return this.navSecond;
	}

	public void setNavSecond(Integer navSecond) {
		this.navSecond = navSecond;
	}

	public Long getFileInfoId() {
		return this.fileInfoId;
	}

	public void setFileInfoId(Long fileInfoId) {
		this.fileInfoId = fileInfoId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}