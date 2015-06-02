package com.sep.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sep.model.Permission;

/**
 * 权限模板
 * 
 * @author ChenTao
 * @date 2015年05月30日下午3:03:38
 */
@Controller("permissionAction")
@Scope("prototype")
@RequestMapping("/permissionAction")
public class PermissionAction extends BaseAction<Permission> {

	private static final long serialVersionUID = -396823179150633905L;

	@SuppressWarnings("unused")
	private static final Log log = LogFactory.getLog(PermissionAction.class);

	// 以下是业务属性
	private Permission permission;

	// Get方法
	public Permission getPermission() {
		return permission;
	}

	// Set方法
	public void setPermission(Permission permission) {
		this.permission = permission;
	}

}