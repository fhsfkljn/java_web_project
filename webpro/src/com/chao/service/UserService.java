package com.chao.service;

import com.chao.domain.User;

public interface UserService {
	/**
	 * ����û���Ϣ
	 * @param user
	 * @throws Exception
	 */
	public void register(User user) throws Exception;
	
	/**
	 * �����û�������������û���Ϣ
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User login(User user) throws Exception;
	
	/**
	 * �жϵ�ǰ�û��Ƿ��Ѿ�ע��
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public boolean isUserExist(String name) throws Exception;
}
