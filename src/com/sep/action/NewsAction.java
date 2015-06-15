package com.sep.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sep.model.News;
import com.sep.util.Condition;
import com.sep.util.Pagination;

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
	 * 
	 * @author ChenTao
	 * @date 2015年6月15日下午3:31:23
	 */
	public String listNews4Front() {
		try {
			if (news == null) {
				throw new Exception("查询条件为空");
			}
			// 查询
			List<Condition> conditions = new ArrayList<Condition>();
			Pagination pagination = new Pagination(true, true);
			pagination.setAmount(10);//设置查询数量
			pagination.setAsc(false);//降序排序
			conditions.add(new Condition("status", "=", 1));
			conditions.add(new Condition("navFirst", "=", 1));
			conditions.add(new Condition("navSecond", "=", 1));
			List<News> newss = this.newsService.listAndSort(pagination, conditions);
			if (newss == null || newss.size() == 0) {
				dataMap.put("success", false);
				return SUCCESS;
			}
			List<News> newsDto = new ArrayList<News>();
			for (News news : newss) {
				
				
			}
			dataMap.put("rows", newss);
			dataMap.put("success", true);
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