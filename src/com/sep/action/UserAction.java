package com.sep.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sep.model.User;
import com.sep.util.Condition;
import com.sep.util.Pagination;

/**
 * 登陆
 * 
 * @author ChenTao
 * @date 2015年05月30日下午3:03:38
 */
@Controller("userAction")
@Scope("prototype")
@RequestMapping("/userAction")
public class UserAction extends BaseAction<User> {

	private static final long serialVersionUID = -2699917502266158193L;

	private static final Log log = LogFactory.getLog(UserAction.class);

	// 以下是业务属性
	private User user;
	private String securityCode;

	/**
	 * 根据帐号和密码，直接进行校验，并在校验完成后，进入对应的系统页面。
	 * 
	 * @author ChenTao
	 * @date 2015年5月30日下午3:30:04
	 */
	public String login() {
		String result = new String();
		String msg = new String();
		try {
			// 校核验证码
			if (securityCode == null || StringUtils.isBlank(securityCode)) {
				msg = "验证码为空";
				throw new Exception(msg);
			}
			String my_SESSION_SECURITY_CODE = (String) session.get("SESSION_SECURITY_CODE");
			if (!securityCode.equals(my_SESSION_SECURITY_CODE)) {
				msg = "验证码不正确";
				throw new Exception(msg);
			}
			// 初始化参数
			String username = user == null ? null : user.getUserName();
			String password = user == null ? null : user.getPassword();
			log.debug("username/" + username);
			if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
				msg = "账号或密码为空";
				throw new Exception(msg);
			}
			// 查询
			List<Condition> conditions = new ArrayList<Condition>();
			Pagination pagination = new Pagination(false, false);
			conditions.add(new Condition("userName", "=", username));
			List<User> users = this.userService.listAndSort(pagination, conditions);
			if (users.size() != 1) {
				if (users.size() == 0) {
					msg = "该用户不存在";
					throw new Exception(msg);
				} else {
					msg = "存在多条数据造成无法显示";
					throw new Exception(msg);
				}
			}
			User existUser = users.get(0);
			if (existUser.getStatus() != 0 && existUser.getPassword().equals(password)) {
				session.put("userId", existUser.getId());
				if (existUser.getRoleId() != null) {
					session.put("roleId", existUser.getRoleId());
					Long permNum = this.permissionService.countTotalAmount(null);
					session.put("permNum", permNum);
					List<Long> permIds = this.permInstanceService.findByRoleId(existUser.getRoleId());
					session.put("permIds", permIds);
					log.debug("permIds/" + permIds);
				}
				result = "main";
			} else if (existUser.getStatus() == 0) {
				msg = "该用户已经被删除";
				throw new Exception(msg);
			} else {
				msg = "密码错误";
				throw new Exception(msg);
			}
		} catch (Exception e) {
			log.debug(e);
			session.put("errorInfo", msg);
			result = "error";
		}
		return result;
	}

	/**
	 * 注册
	 * 
	 * @author ChenTao
	 * @date 2015年5月30日下午3:30:33
	 */
	public String registerUser() {
		try {
			// 先判断参数
			if (user == null) {
				throw new Exception("数据为空");
			}
			// 校核
			if (StringUtils.isEmpty(user.getUserName()) || StringUtils.isEmpty(user.getPassword())) {
				dataMap.put("message", "必填项目为空,新增失败");
				dataMap.put("success", false);
				return SUCCESS;
			}
			// 检查登陆名称重复
			if (!checkUserName(user.getUserName())) {
				dataMap.put("message", "登陆名称重复");
				dataMap.put("success", false);
				return SUCCESS;
			}
			// 设置状态
			user.setStatus(1);
			// 新增 User
			this.userService.save(user);
			// 结果集
			dataMap.put("message", "注册成功");
			dataMap.put("success", true);
		} catch (Exception e) {
			log.debug(e);
			String msg = "系统异常";
			dataMap.put("message", msg);
			dataMap.put("success", false);
		}
		return SUCCESS;
	}

	/**
	 * 检查登陆名称重复 true为不重复
	 * 
	 * @author ChenTao
	 * @date 2015年5月30日下午3:57:00
	 */
	public Boolean checkUserName(String checkName) {
		try {
			// 查找 user
			List<Condition> conditions = new ArrayList<Condition>();
			Pagination pagination = new Pagination(false, false);// 不分页不排序
			conditions.add(new Condition("userName", "=", checkName));
			List<User> users = this.userService.listAndSort(pagination, conditions);
			if (users == null || users.size() == 0) {
				return true;
			}
		} catch (Exception e) {
			log.debug(e);
		}
		return false;
	}

	// Get方法
	public User getUser() {
		return user;
	}

	// Set方法
	public void setUser(User user) {
		this.user = user;
	}

	// Get方法
	public String getSecurityCode() {
		return securityCode;
	}

	// Set方法
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

}