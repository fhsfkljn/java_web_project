package com.chao.mybatis.dao;

import java.util.List;

import com.chao.mybatis.po.User;

public interface UserDao {
	// 1�� �����û�ID��ѯ�û���Ϣ
	public User findUserById(int id) throws Exception;

	// 2�� �����û�����ģ����ѯ�û��б�
	public List<User> findUsersByName(String name) throws Exception;

	// 3�� ����û�
	public void insertUser(User user) throws Exception;
}
