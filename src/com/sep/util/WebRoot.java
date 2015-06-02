package com.sep.util;

import java.io.File;

/**
 * 获取WebRoot路径
 * 
 * @author ChenTao
 * @date 2014年12月15日下午4:51:53
 */
public class WebRoot {

	public static String getPath() {
		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();
		if (classLoader == null) {
			classLoader = ClassLoader.getSystemClassLoader();
		}
		java.net.URL url = classLoader.getResource("");
		String ROOT_CLASS_PATH = url.getPath() + "/";
		File rootFile = new File(ROOT_CLASS_PATH);
		String WEB_INFO_DIRECTORY_PATH = rootFile.getParent() + "/";
		File webInfoDir = new File(WEB_INFO_DIRECTORY_PATH);
		String SERVLET_CONTEXT_PATH = webInfoDir.getParent() + "/";
		// 这里 SERVLET_CONTEXT_PATH 就是WebRoot的路径
		String path = SERVLET_CONTEXT_PATH;
		path = path.replaceAll("%20", " ");
		return path;
	}

}
