package com.chao.service;

import java.util.List;

import com.chao.domain.User;

/**
 * 用户操作相关接口
 * @author 89591
 *
 */
public interface IUserService {
	
	/**
	 * 用户登录
	 * @param loginName
	 * @param loginPwd
	 * @return
	 */
	User login(String loginName,String loginPwd);
	
	/**
	 * 保存用户
	 * @param user
	 * @return
	 */
	int saveUser(User user);
	
	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	int modify(User user);
	
	/**
	 * 根据用户id删除用户
	 * @param UserID
	 * @return
	 */
	int removeUser(Integer userID);
	
	/**
	 * 根据用户id获取用户信息
	 * @param userID
	 * @return
	 */
	User findUserById(Integer userID);
	
	/**
	 * 查询所有用户
	 * @return
	 */
	List<User> findAllUser();
	
	/**
	 * 根据条件查询用户
	 * @param userName
	 * @param gender
	 * @param education
	 * @param isUpload
	 * @return
	 */
	List<User> findUserByCondition(String userName,String gender,String education,String isUpload);
}
