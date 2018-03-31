package com.chao.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class HibernateUtils {
	private static SessionFactory sf;

	static {
		// 1��������
		Configuration conf = new Configuration().configure();
		// 2 ����Configuration ������Ϣ���� SessionFactory
		sf = conf.buildSessionFactory();
		//
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("������ر�!�ͷ���Դ");
				sf.close();
			}
		}));

	}

	public static org.hibernate.Session openSession() {

		// 3 ���session
		Session session = sf.openSession();

		return session;
	}

	public static org.hibernate.Session getCurrentSession() {
		// 3 ���session
		Session session = sf.getCurrentSession();

		return session;
	}

	public static void main(String[] args) {
		System.out.println(openSession());
	}
}
