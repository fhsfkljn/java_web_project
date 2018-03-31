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
		//1.读取配置文件
		Configuration conf = new Configuration().configure();
		//2.根据配置创建一个factory
		SessionFactory sessionFactory = conf.buildSessionFactory();
		//3.通过factory获得操作数据库的session对象
		Session session = sessionFactory.openSession();
		//4.操作数据库
		User user = new User();
		user.setUsername("tom");
		user.setPassword("123");
		
		//5 开启事务
		Transaction transaction = session.beginTransaction();
		
		session.save(user);
		
		//6 提交事务 | 回滚事务
		transaction.commit();
		
		//7.关闭资源
		session.close();
		sessionFactory.close();
	}
	
	public static void main(String[] args) {
		
	}
}
