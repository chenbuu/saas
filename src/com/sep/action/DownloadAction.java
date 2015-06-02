package com.sep.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sep.model.FileInfo;

/**
 * 下载
 * 
 * @author ChenTao
 * @date 2015年2月26日下午5:10:45
 */
@Controller("downloadAction")
@Scope("prototype")
@RequestMapping("/downloadAction")
public class DownloadAction extends BaseAction<FileInfo> {

	private static final long serialVersionUID = -2940649474355715762L;

	private static final Log log = LogFactory.getLog(DownloadAction.class);

	// 以下是业务属性
	private String fileName;// 此属性为接受前台界面传过来的属性名

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) throws Exception {
		/*
		 * 这里面转码的，原因是，前台传过来的形式是ISO-8859格式 ，到后台我们还要转成UTF_8，避免中文乱码等原因
		 */
		// this.fileName = new String(fileName.getBytes("ISO-8859-1"),"UTF-8");

		// 前后台都为utf8的时候直接获取就行了
		this.fileName = fileName;
	}

	/**
	 * 此方法对应struts.xml文件中的<param name="inputName">inputStream</param>属性
	 * 
	 * @return
	 * @throws Exception
	 */
	public InputStream getInputStream() {
		try {
			// 根据url 找到该文件
			File file = new File(fileName);
			// 截取前台传过来的超链接地址后的文件名，作为显示用
			String filename = fileName.substring(fileName.lastIndexOf("\\") + 1, fileName.length());
			// 把url替换成文件名称
			// 根据request的locale 得出可能的编码，中文操作系统通常是gb2312
			fileName = new String(filename.getBytes("gb2312"), "ISO-8859-1");
			// 将文件地址转换成文件，然后转换成流,将流返回
			InputStream myInputStream = new FileInputStream(file);
			return myInputStream;
		} catch (Exception e) {
			log.debug(e);
			String msg = "下载系统异常";
			log.error(msg, e);
		}
		return null;
	}

	/**
	 * 此方法是前台点击下载后的响应方法
	 * 
	 * @return
	 * @throws Exception
	 */
	public String filedownload() throws Exception {
		return SUCCESS;
	}

}
