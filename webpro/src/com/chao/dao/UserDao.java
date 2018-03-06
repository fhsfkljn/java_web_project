package com.chao.dao;

import com.chao.domain.User;

public interface UserDao {
	
	/**
	 * ����û���Ϣ
	 * @param user
	 * @throws Exception
	 */
	public void addUser(User user) throws Exception;
	
	/**
	 * �����û�������������û���Ϣ
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User findUser(User user) throws Exception;
	
	/**
	 * �ж��û��Ƿ��Ѿ�����
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean isUserExist(String name) throws Exception;
}
