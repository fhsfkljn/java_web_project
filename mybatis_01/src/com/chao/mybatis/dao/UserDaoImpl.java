package com.chao.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.chao.mybatis.po.User;

public class UserDaoImpl implements UserDao {

	// ����ע��
	private SqlSessionFactory sqlSessionFactory;

	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public User findUserById(int id) throws Exception {
		// ����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// ����SqlSession����ɾ�Ĳ鷽��
		// ��һ����������ʾstatement��Ψһ��ʾ
		User user = sqlSession.selectOne("test.findUserById", id);
		System.out.println(user);
		// �ر���Դ
		sqlSession.close();
		return user;
	}

	@Override
	public List<User> findUsersByName(String name) {
		// ����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// ����SqlSession����ɾ�Ĳ鷽��
		// ��һ����������ʾstatement��Ψһ��ʾ
		List<User> list = sqlSession.selectOne("test.findUsersByName", name);
		System.out.println(list);
		// �ر���Դ
		sqlSession.close();
		return list;
	}

	@Override
	public void insertUser(User user) {
		// ����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// ����SqlSession����ɾ�Ĳ鷽��
		// ��һ����������ʾstatement��Ψһ��ʾ
		sqlSession.insert("test.insertUser", user);

		System.out.println(user.getId());
		// �ύ����
		sqlSession.commit();
		// �ر���Դ
		sqlSession.close();
	}

}
