package com.chao.lifecycle;

public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		System.out.println("hello spring lifeCycle");
	}
	
	public void myInit(){
		System.out.println("��ʼ������");
	}
	
	public void myDestory(){
		System.out.println("���ٷ���");
	}

}
