package com.chao.dao;

import com.chao.domain.User;

/**
 * 用户相关操作的持久层接口
 * @author 89591
 *
 */
public interface IUserDao {

	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 */
	User selectUserByUsername(String username);

	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	int addUser(User user);
	
}
