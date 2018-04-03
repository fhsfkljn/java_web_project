package com.chao.web.action;

import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.chao.dao.TopicDao;
import com.chao.dao.TopicDaoImpl;
import com.chao.domain.Topic;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TopicAction extends ActionSupport {

	private Topic topic;
	private TopicDao dao = new TopicDaoImpl();
	private String key;

	// 帖子列表
	public String list() {
		// 1调用dao获得帖子列表
		List<Topic> list = dao.getAll(key);
		// 2 将帖子列表放入ActionContext中
		ActionContext.getContext().put("list", list);

		return "list";
	}

	public String add() {
		// 1 ip
		topic.setIpAddr(ServletActionContext.getRequest().getRemoteAddr());
		// 2 创建/回帖时间
		topic.setCreateDate(new Date());
		topic.setLastReplyDate(topic.getCreateDate());
		// 3保存
		dao.save(topic);

		return "toList";
	}

	//---------------------------------------------
	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	

}
