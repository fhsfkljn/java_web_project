package com.chao.dao;

import com.chao.domain.User;

public interface UserDao {
	
	/**
	 * 添加用户信息
	 * @param user
	 * @throws Exception
	 */
	public void addUser(User user) throws Exception;
	
	/**
	 * 根据用户名和密码查找用户信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User findUser(User user) throws Exception;
	
	/**
	 * 判断用户是否已经存在
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean isUserExist(String name) throws Exception;
}
