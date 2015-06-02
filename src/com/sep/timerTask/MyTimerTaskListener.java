package com.sep.timerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 定时任务监听器(需要在web.xml里配置才能有效)
 * @author ChenTao
 * @date 2015年3月5日下午1:14:59
 */
public class MyTimerTaskListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent event) {
		new TimerManager();
	}

	public void contextDestroyed(ServletContextEvent event) {
	}

}
