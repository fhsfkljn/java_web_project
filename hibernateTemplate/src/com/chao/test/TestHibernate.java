package com.chao.test;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

import com.chao.domain.User;

public class TestHibernate {
	
	@Test
	public void fun1(){
		//1.��ȡ�����ļ�
		Configuration conf = new Configuration().configure();
		//2.�������ô���һ��factory
		SessionFactory sessionFactory = conf.buildSessionFactory();
		//3.ͨ��factory��ò������ݿ��session����
		Session session = sessionFactory.openSession();
		//4.�������ݿ�
		User user = new User();
		user.setUsername("tom");
		user.setPassword("123");
		
		//5 ��������
		Transaction transaction = session.beginTransaction();
		
		session.save(user);
		
		//6 �ύ���� | �ع�����
		transaction.commit();
		
		//7.�ر���Դ
		session.close();
		sessionFactory.close();
	}
	
	public static void main(String[] args) {
		
	}
}
