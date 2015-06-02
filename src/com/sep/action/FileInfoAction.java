package com.sep.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sep.model.FileInfo;

/**
 * 文件操作
 * 
 * @author ChenTao
 * @date 2015年05月30日下午3:03:38
 */
@Controller("fileInfoAction")
@Scope("prototype")
@RequestMapping("/fileInfoAction")
public class FileInfoAction extends BaseAction<FileInfo> {

	private static final long serialVersionUID = 565738650344113484L;

	@SuppressWarnings("unused")
	private static final Log log = LogFactory.getLog(FileInfoAction.class);

	// 以下是业务属性
	private FileInfo fileInfo;

	// Get方法
	public FileInfo getFileInfo() {
		return fileInfo;
	}

	// Set方法
	public void setFileInfo(FileInfo fileInfo) {
		this.fileInfo = fileInfo;
	}

}