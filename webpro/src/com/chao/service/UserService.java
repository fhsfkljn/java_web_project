package com.chao.service;

import com.chao.domain.User;

public interface UserService {
	/**
	 * 添加用户信息
	 * @param user
	 * @throws Exception
	 */
	public void register(User user) throws Exception;
	
	/**
	 * 根据用户名和密码查找用户信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User login(User user) throws Exception;
	
	/**
	 * 判断当前用户是否已经注册
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public boolean isUserExist(String name) throws Exception;
}
