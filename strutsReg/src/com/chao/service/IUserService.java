package com.chao.service;

import com.chao.domain.User;

public interface IUserService {
	
	/**
	 * 根据用户名判断用户是否存在
	 * @param username
	 * @return
	 */
	User findUserByUsername(String username);
	
	/**
	 * 用户注册:返回影响数据库的行数
	 * @param user
	 * @return
	 */
	int register(User user);
}
