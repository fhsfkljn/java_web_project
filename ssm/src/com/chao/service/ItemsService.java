package com.chao.service;

import java.util.List;

import com.chao.domain.Items;

public interface ItemsService {

	List<Items> findAll();

	Items findById(Integer id);

	void saveOrUpdate(Items items);

	void deleteByID(Integer id);
	
}
