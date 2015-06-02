package com.sep.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sep.model.Tenant;

/**
 * 多租户
 * 
 * @author ChenTao
 * @date 2015年05月30日下午3:03:38
 */
@Controller("tenantAction")
@Scope("prototype")
@RequestMapping("/tenantAction")
public class TenantAction extends BaseAction<Tenant> {

	private static final long serialVersionUID = -396823179150633905L;

	@SuppressWarnings("unused")
	private static final Log log = LogFactory.getLog(TenantAction.class);

	// 以下是业务属性
	private Tenant tenant;

	// Get方法
	public Tenant getTenant() {
		return tenant;
	}

	// Set方法
	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

}