package com.sep.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sep.service.UserService;

/**
 *
 * @author ChenTao
 * @date 2014年10月12日下午2:43:44
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:beans.xml"})
public class ChentaoTest {

    @Autowired(required = false)
    @Resource(name = "userService")
    private UserService userService;

    @Test
    public void test() {
        System.out.println("开始================");
        try {
            // 测试内容
            String str = this.userService.findById(1L).getRealName();
            System.out.println("测试内容/" + str);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("结束================");
    }

	// Get方法
	public UserService getUserService() {
		return userService;
	}

	// Set方法
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
