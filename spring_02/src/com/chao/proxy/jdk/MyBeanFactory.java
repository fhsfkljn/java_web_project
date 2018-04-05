package com.chao.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyBeanFactory {

	public static UserService createService(){
		//1 Ŀ����
		final UserService userService = new UserServiceImpl();
		
		//2������
		final MyAspect myAspect = new MyAspect();
		
		/* 3 �����ࣺ��Ŀ���ࣨ����㣩�� �����֪ࣨͨ�� ��� --> ����
		 * 	Proxy.newProxyInstance
		 * 		����1��loader �������������̬������ ����ʱ�������κ��඼��Ҫ�������������ص��ڴ档
		 * 			һ���������ǰ��.class.getClassLoader();
		 * 					Ŀ����ʵ��.getClass().get...
		 * 		����2��Class[] interfaces ��������Ҫʵ�ֵ����нӿ�
		 * 			��ʽ1��Ŀ����ʵ��.getClass().getInterfaces()  ;ע�⣺ֻ�ܻ���Լ��ӿڣ����ܻ�ø�Ԫ�ؽӿ�
		 * 			��ʽ2��new Class[]{UserService.class}   
		 * 			���磺jdbc ����  --> DriverManager  ��ýӿ� Connection
		 * 		����3��InvocationHandler  �����࣬�ӿڣ��������ʵ���࣬һ����������ڲ�
		 * 			�ṩ invoke �������������ÿһ������ִ��ʱ����������һ��invoke
		 * 				����31��Object proxy ���������
		 * 				����32��Method method : �������ǰִ�еķ������������󣨷��䣩
		 * 					ִ�з�������method.getName()
		 * 					ִ�з�����method.invoke(����ʵ�ʲ���)
		 * 				����33��Object[] args :����ʵ�ʲ���
		 * 
		 */
		UserService proxyService = (UserService)Proxy.newProxyInstance(
				MyBeanFactory.class.getClassLoader(), 
				userService.getClass().getInterfaces(),
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						
						//ǰִ��
						myAspect.before();
						
						//ִ��Ŀ����ķ���
						Object obj = method.invoke(userService, args);
						
						//��ִ��
						myAspect.after();
						
						return obj;
					}
				});
		
		return proxyService;
	}
	
}
