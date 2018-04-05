package com.chao.proxy.cglib;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class MyBeanFactory {

	public static UserServiceImpl createService(){
		//1 Ŀ����
		final UserServiceImpl userService = new UserServiceImpl();
		
		//2������
		final MyAspect myAspect = new MyAspect();
		
		// 3.������ ������cglib���ײ㴴��Ŀ���������
		//3.1 ������
		Enhancer enhancer = new Enhancer();
		
		//3.2 ȷ������
		enhancer.setSuperclass(userService.getClass());
		
		/* 3.3 ���ûص����� , MethodInterceptor�ӿ� ��Ч jdk InvocationHandler�ӿ�
		 * 	intercept() ��Ч jdk  invoke()
		 * 		����1������2������3����invokeһ��
		 * 		����4��methodProxy �����Ĵ���
		 * 		
		 * 
		 */
		enhancer.setCallback(new MethodInterceptor() {
			
			@Override
			public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
				//ǰ
				myAspect.before();
				
				//ִ��Ŀ����ķ���
				Object obj = method.invoke(userService, args);
				// * ִ�д�����ĸ��� ��ִ��Ŀ���� ��Ŀ����ʹ����� ���ӹ�ϵ��
				//methodProxy.invokeSuper(proxy, args);
				
				//��
				myAspect.after();
				
				return obj;
			}
		});
		
		//3.4 ��������
		UserServiceImpl proxyService = (UserServiceImpl) enhancer.create();
		
		return proxyService;
	}
	
}
