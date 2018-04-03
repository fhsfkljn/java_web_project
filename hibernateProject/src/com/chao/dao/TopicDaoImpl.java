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

		// 1 ���session
		Session session = HibernateUtils.getCurrentSession();
		// 2 ����query����
		Query query = session.createQuery("from Topic where title like :key ");
		// 3 ���ò���
		if (key != null && !"".equals(key.trim())) {// ҳ�洫������
			query.setString("key", "%" + key + "%");
		} else {// ҳ��û������=>��ѯ����
			query.setString("key", "%");
		}
		// 4 ��ѯ list
		return query.list();
	}

}
