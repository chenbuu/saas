package com.sep.security;

import java.io.ByteArrayInputStream;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 提供图片验证码
 * 
 * @author ChenTao
 * @date 2015年3月17日上午12:07:43
 */
@Controller("securityCodeImageAction")
@Scope("prototype")
@RequestMapping("/securityCodeImageAction")
public class SecurityCodeImageAction extends ActionSupport {

	private static final long serialVersionUID = 2615603904709085313L;

	private static final Log log = LogFactory.getLog(SecurityCodeImageAction.class);

	// 以下是页面必要参数
	private Map<String, Object> session;

	// 图片流
	private ByteArrayInputStream imageStream;

	// 以下是默认构造函数
    public SecurityCodeImageAction() throws Exception {
        try {
            session = ActionContext.getContext().getSession();
        } catch (Exception e) {

        }
    }
    
	public String getCodeImage() {
		try {
			// 如果开启Hard模式，可以不区分大小写
			// String securityCode =
			// SecurityCode.getSecurityCode(4,SecurityCodeLevel.Hard,
			// false).toLowerCase();

			// 获取默认难度和长度的验证码
			String securityCode = SecurityCode.getSecurityCode();
			imageStream = SecurityImage.getImageAsInputStream(securityCode);
			// 放入session中
			session.put("SESSION_SECURITY_CODE", securityCode);
			return SUCCESS;
		} catch (Exception e) {
			log.debug(e);
        	String msg = "验证码系统异常";
            log.error(msg, e);
		}
		return null;
	}

	// Get方法
	public ByteArrayInputStream getImageStream() {
		return imageStream;
	}

	// Set方法
	public void setImageStream(ByteArrayInputStream imageStream) {
		this.imageStream = imageStream;
	}
	
	// Get方法
	public Map<String, Object> getSession() {
		return session;
	}

	// Set方法
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
