package com.chao.service;

import com.chao.domain.User;

public interface IUserService {
	
	/**
	 * �����û����ж��û��Ƿ����
	 * @param username
	 * @return
	 */
	User findUserByUsername(String username);
	
	/**
	 * �û�ע��:����Ӱ�����ݿ������
	 * @param user
	 * @return
	 */
	int register(User user);
}
