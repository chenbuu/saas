package com.sep.model;
// default package

import java.sql.Timestamp;

/**
 * FileInfo entity. @author MyEclipse Persistence Tools
 */

public class FileInfo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 203870849930587299L;
	private Long id;
	private Timestamp createTime;
	private String fileName;
	private String fileUrl;

	// Constructors

	/** default constructor */
	public FileInfo() {
	}

	/** full constructor */
	public FileInfo(Timestamp createTime, String fileName, String fileUrl) {
		this.createTime = createTime;
		this.fileName = fileName;
		this.fileUrl = fileUrl;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileUrl() {
		return this.fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

}