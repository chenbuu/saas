package com.sep.action;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.opensymphony.xwork2.ActionContext;
import com.sep.model.FileInfo;
import com.sep.util.Consts;

/**
 * 文件上传
 * 
 * @author ChenTao
 * @date 2015年2月26日下午3:04:42
 */
@Controller("uploadAction")
@Scope("prototype")
@RequestMapping("/uploadAction")
public class UploadAction extends BaseAction<FileInfo> {

	private static final long serialVersionUID = -3880210631829718045L;

	private static final Log log = LogFactory.getLog(UploadAction.class);

	// 以下是业务属性
	private File file;// 文件，跟前台文本框里的文件名相对应
	private String fileFileName;// 上传文件的文件名
	private File fileUrl; // 存放文件的文件名
	private ActionContext ac;

	/**
	 * 上传(先保存文件名，再生成路径，最后再上传)
	 * 
	 * @author ChenTao
	 * @date 2015年2月26日下午3:12:04
	 */
	public String upload() {
		try {
			// 将文件的名称放在数据库中
			FileInfo fileInfo = new FileInfo();
			fileInfo.setFileName(fileFileName);
			this.fileInfoService.save(fileInfo);
			// 打算存放文件的路径
			String filepath = Consts.UPLOAD_DEFAULT + "/" + fileInfo.getId();
			// 查看该路径存在与否，遇过不存在，创建路径
			if (!new File(filepath).isDirectory()) {
				new File(filepath).mkdirs();
			}
			// 上传文件
			fileUrl = new File(filepath + "/" + fileFileName);
			// 将文件复制到服务器上指定的路径
			FileUtils.copyFile(file, fileUrl);
			// 将文件的路径放在数据库中 转换成文件的具体路径
			fileInfo.setFileUrl(fileUrl.getAbsolutePath());
			// 将文件的具体地址存放到数据库，为下载做准备
			this.fileInfoService.update(fileInfo);
			dataMap.put("id", fileInfo.getId());
			dataMap.put("success", true);
		} catch (Exception e) {
			log.debug(e);
			String msg = "上传系统异常";
			log.error(msg, e);
			dataMap.put("message", msg);
			dataMap.put("success", false);
		}
		return SUCCESS;
	}

	// Get方法
	public File getFile() {
		return file;
	}

	// Set方法
	public void setFile(File file) {
		this.file = file;
	}

	// Get方法
	public String getFileFileName() {
		return fileFileName;
	}

	// Set方法
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	// Get方法
	public File getFileUrl() {
		return fileUrl;
	}

	// Set方法
	public void setFileUrl(File fileUrl) {
		this.fileUrl = fileUrl;
	}

	// Get方法
	public ActionContext getAc() {
		return ac;
	}

	// Set方法
	public void setAc(ActionContext ac) {
		this.ac = ac;
	}

}
