package com.sep.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sep.model.News;

/**
 * 咨询
 * 
 * @author ChenTao
 * @date 2015年6月15日下午3:27:17
 */
@Controller("newsAction")
@Scope("prototype")
@RequestMapping("/newsAction")
public class NewsAction extends BaseAction<News> {

	private static final long serialVersionUID = -3572925177560618414L;

	private static final Log log = LogFactory.getLog(NewsAction.class);

	// 以下是业务属性
	private News news;

	/**
	 * 根据条件列出咨询
	 * @author ChenTao
	 * @date 2015年6月15日下午3:31:23
	 */
	public String listNews() {
		try {
			
			
		} catch (Exception e) {
            String msg = "系统异常";
            log.error(msg, e);
            dataMap.put("message", msg);
            dataMap.put("success", false);
        }
		return SUCCESS;
	}
	
	// Get方法
	public News getNews() {
		return news;
	}

	// Set方法
	public void setNews(News news) {
		this.news = news;
	}

}