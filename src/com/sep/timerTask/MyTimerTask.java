package com.sep.timerTask;

import java.util.TimerTask;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 定时任务具体实现类(在这里写你要执行的内容)
 * @author ChenTao
 * @date 2015年3月5日下午1:06:24
 */
public class MyTimerTask extends TimerTask {

	private static final Log log = LogFactory.getLog(MyTimerTask.class);
	
	// 以下是服务层引用
	AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(new String []{"beans.xml"});
	//private GdService gdService = (GdServiceImpl)ctx.getBean("gdService");

	@Override
	public void run() {
		try {
			// 信息
			System.out.println("信息: 任务定时器开始执行");
			// 在这里写你要执行的内容
			//this.gdService.timerTask4Pj();
			
			// 信息
			System.out.println("信息: 任务定时器执行结束");
		} catch (Exception e) {
			System.out.println(e);
			log.info("------定时任务发生异常------");
		}
	}

	/*//Get方法
	public GdService getGdService() {
		return gdService;
	}

	//Set方法
	public void setGdService(GdService gdService) {
		this.gdService = gdService;
	}*/
	
}