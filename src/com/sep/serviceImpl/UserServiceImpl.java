package com.sep.serviceImpl;

import org.springframework.stereotype.Service;

import com.sep.model.User;
import com.sep.service.UserService;

/**
 * 
 * @author ChenTao
 * @date 2015年05月29日下午9:43:37
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

}