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
		// 读取配置文件
		// 全局配置文件的路径
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 调用SqlSession的增删改查方法
		// 第一个参数：表示statement的唯一标示
		User user = sqlSession.selectOne("test.findUserById", 1);
		System.out.println(user);

		// 关闭资源
		sqlSession.close();
	}

	@Test
	public void findUserByName() throws IOException {
		// 读取配置文件
		// 全局配置文件的路径
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 调用SqlSession的增删改查方法
		// 第一个参数：表示statement的唯一标示
		List<User> list = sqlSession.selectList("test.findUsersByName", "小明");
		System.out.println(list);
		//关闭资源
		sqlSession.close();
	}
}
