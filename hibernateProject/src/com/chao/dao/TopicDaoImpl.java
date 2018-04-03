package com.chao.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.chao.domain.Topic;
import com.chao.utils.HibernateUtils;

public class TopicDaoImpl implements TopicDao {

	@Override
	public void save(Topic t) {
		Session session = HibernateUtils.getCurrentSession();
		session.save(t);
	}

	@Override
	public List<Topic> getAll(String key) {

		// 1 获得session
		Session session = HibernateUtils.getCurrentSession();
		// 2 创建query对象
		Query query = session.createQuery("from Topic where title like :key ");
		// 3 设置参数
		if (key != null && !"".equals(key.trim())) {// 页面传条件了
			query.setString("key", "%" + key + "%");
		} else {// 页面没传条件=>查询所有
			query.setString("key", "%");
		}
		// 4 查询 list
		return query.list();
	}

}
