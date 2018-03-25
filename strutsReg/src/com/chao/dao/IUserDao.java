package com.chao.dao;

import com.chao.domain.User;

/**
 * �û���ز����ĳ־ò�ӿ�
 * @author 89591
 *
 */
public interface IUserDao {

	/**
	 * �����û��������û�
	 * @param username
	 * @return
	 */
	User selectUserByUsername(String username);

	/**
	 * �û�ע��
	 * @param user
	 * @return
	 */
	int addUser(User user);
	
}
