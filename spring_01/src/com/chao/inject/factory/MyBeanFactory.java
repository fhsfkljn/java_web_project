package com.chao.inject.factory;

/**
 * ʵ������,���з����Ǿ�̬
 *
 */
public class MyBeanFactory {

	/**
	 * ����ʵ��
	 * @return
	 */
	public UserService createService(){
		return new UserServiceImpl();
	}
}
