package com.chao.dao;

import java.util.List;

import com.chao.domain.Topic;

public interface TopicDao {
	/**
	 * ��������
	 */
	void save(Topic t);
	
	/**
	 * �����б�
	 */
	List<Topic> getAll(String key);
}
