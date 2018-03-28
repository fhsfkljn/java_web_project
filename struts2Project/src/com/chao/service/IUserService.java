package com.chao.service;

import java.util.List;

import com.chao.domain.User;

/**
 * �û�������ؽӿ�
 * @author 89591
 *
 */
public interface IUserService {
	
	/**
	 * �û���¼
	 * @param loginName
	 * @param loginPwd
	 * @return
	 */
	User login(String loginName,String loginPwd);
	
	/**
	 * �����û�
	 * @param user
	 * @return
	 */
	int saveUser(User user);
	
	/**
	 * �޸��û�
	 * @param user
	 * @return
	 */
	int modify(User user);
	
	/**
	 * �����û�idɾ���û�
	 * @param UserID
	 * @return
	 */
	int removeUser(Integer userID);
	
	/**
	 * �����û�id��ȡ�û���Ϣ
	 * @param userID
	 * @return
	 */
	User findUserById(Integer userID);
	
	/**
	 * ��ѯ�����û�
	 * @return
	 */
	List<User> findAllUser();
	
	/**
	 * ����������ѯ�û�
	 * @param userName
	 * @param gender
	 * @param education
	 * @param isUpload
	 * @return
	 */
	List<User> findUserByCondition(String userName,String gender,String education,String isUpload);
}
