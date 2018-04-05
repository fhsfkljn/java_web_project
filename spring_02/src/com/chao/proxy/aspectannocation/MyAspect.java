package com.chao.proxy.aspectannocation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * �����࣬���ж��֪ͨ
 */
@Component
@Aspect
public class MyAspect {

	// �������������
	@Pointcut("execution(* com.chao.proxy.aspectannocation.UserServiceImpl.*(..))")
	private void myPointCut() {
	}

	//@Before("execution(* com.chao.proxy.aspectannocation.UserServiceImpl.*(..))")
	public void myBefore(JoinPoint joinPoint) {
		System.out.println("ǰ��֪ͨ �� " + joinPoint.getSignature().getName());
	}

	//@AfterReturning(value="myPointCut()" ,returning="ret")
	public void myAfterReturning(JoinPoint joinPoint, Object ret) {
		System.out.println("����֪ͨ �� " + joinPoint.getSignature().getName() + " , -->" + ret);
	}

	@Around(value = "myPointCut()")
	public Object myAround(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("ǰ");
		// �ֶ�ִ��Ŀ�귽��
		Object obj = joinPoint.proceed();

		System.out.println("��");
		return obj;
	}

	//@AfterThrowing(value="execution(* com.itheima.d_aspect.b_anno.UserServiceImpl.*(..))" ,throwing="e")
	public void myAfterThrowing(JoinPoint joinPoint, Throwable e) {
		System.out.println("�׳��쳣֪ͨ �� " + e.getMessage());
	}

	//@After("myPointCut()")
	public void myAfter(JoinPoint joinPoint) {
		System.out.println("����֪ͨ");
	}

}
