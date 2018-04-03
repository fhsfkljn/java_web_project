package com.chao.dao;

import java.util.List;

import com.chao.domain.Topic;

public interface TopicDao {
	/**
	 * 保存帖子
	 */
	void save(Topic t);
	
	/**
	 * 帖子列表
	 */
	List<Topic> getAll(String key);
}
