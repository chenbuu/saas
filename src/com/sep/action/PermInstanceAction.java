package com.sep.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sep.model.PermInstance;

/**
 * 权限实例
 * 
 * @author ChenTao
 * @date 2015年05月30日下午3:03:38
 */
@Controller("permInstanceAction")
@Scope("prototype")
@RequestMapping("/permInstanceAction")
public class PermInstanceAction extends BaseAction<PermInstance> {

	private static final long serialVersionUID = -396823179150633905L;

	@SuppressWarnings("unused")
	private static final Log log = LogFactory.getLog(PermInstanceAction.class);

	// 以下是业务属性
	private PermInstance permInstance;

	// Get方法
	public PermInstance getPermInstance() {
		return permInstance;
	}

	// Set方法
	public void setPermInstance(PermInstance permInstance) {
		this.permInstance = permInstance;
	}

}