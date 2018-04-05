package com.chao.proxy.springaop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * ��������ȷ��֪ͨ����Ҫʵ�ֲ�ͬ�ӿڣ��ӿھ��ǹ淶���Ӷ���ȷ���������ơ� * ���á�����֪ͨ�� MethodInterceptor
 *
 */
public class MyAspect implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {

		System.out.println("����");

		// �ֶ�ִ��Ŀ�귽��
		Object obj = mi.proceed();

		System.out.println("ţβ");
		return obj;

	}

}
