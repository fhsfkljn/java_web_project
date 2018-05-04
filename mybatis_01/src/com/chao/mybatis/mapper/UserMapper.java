package com.chao.mybatis.mapper;

import java.util.List;

import com.chao.mybatis.po.User;
import com.chao.mybatis.po.UserQueryVO;

public interface UserMapper {
	// 1�� �����û�ID��ѯ�û���Ϣ
	public User findUserById(int id) throws Exception;

	// 3�� ����û�
	public void insertUser(User user) throws Exception;

	// �ۺϲ�ѯ
	public List<User> findUserList(UserQueryVO vo);

	// �ۺϲ�ѯ�û�����
	public int findUserCount(UserQueryVO vo);

	// resultMap����
	public User findUserRstMap(int id);
}
