package com.chao.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.chao.mybatis.po.User;

public class MyBatisTest {

	@Test
	public void findUserById() throws IOException {
		// ��ȡ�����ļ�
		// ȫ�������ļ���·��
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// ����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// ����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// ����SqlSession����ɾ�Ĳ鷽��
		// ��һ����������ʾstatement��Ψһ��ʾ
		User user = sqlSession.selectOne("test.findUserById", 1);
		System.out.println(user);

		// �ر���Դ
		sqlSession.close();
	}

	@Test
	public void findUserByName() throws IOException {
		// ��ȡ�����ļ�
		// ȫ�������ļ���·��
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// ����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// ����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// ����SqlSession����ɾ�Ĳ鷽��
		// ��һ����������ʾstatement��Ψһ��ʾ
		List<User> list = sqlSession.selectList("test.findUsersByName", "С��");
		System.out.println(list);
		//�ر���Դ
		sqlSession.close();
	}
}
