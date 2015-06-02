package com.sep.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sep.model.Role;
import com.sep.util.ComboBox;
import com.sep.util.Condition;
import com.sep.util.Pagination;

/**
 * 角色
 * 
 * @author ChenTao
 * @date 2015年05月30日下午3:03:38
 */
@Controller("roleAction")
@Scope("prototype")
@RequestMapping("/roleAction")
public class RoleAction extends BaseAction<Role> {

	private static final long serialVersionUID = -396823179150633905L;

	private static final Log log = LogFactory.getLog(RoleAction.class);

	// 以下是业务属性
	private Role role;

	/**
	 * 查询下拉框字典
	 * 
	 * @author ChenTao
	 * @date 2015年5月30日下午3:47:59
	 */
	public String role4Box() {
		try {
			// 先判断用户权限
			if (userId == null) {
				throw new Exception("用户为空");
			}
			List<Condition> conditions = new ArrayList<Condition>();
			Pagination pagination = new Pagination();// 不分页不排序
			// 查询
			List<Role> roles = this.roleService.listAndSort(pagination, conditions);
			List<ComboBox> ComboBoxs = new ArrayList<ComboBox>();
			for (Role role : roles) {
				ComboBoxs.add(new ComboBox(role.getId(), role.getRoleName()));
			}
			dataMap.put("box", ComboBoxs);
			dataMap.put("success", true);
		} catch (Exception e) {
			dataMap.put("message", "参数不足导致无法查询字典");
			dataMap.put("success", false);
			log.debug(e);
		}
		return SUCCESS;
	}

	// Get方法
	public Role getRole() {
		return role;
	}

	// Set方法
	public void setRole(Role role) {
		this.role = role;
	}

}