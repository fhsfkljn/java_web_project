package com.chao.jd.service;

import com.chao.jd.po.ResultModel;

public interface ProductService {
	
	public ResultModel getProducts(String queryString, String catalogName,
			String price, String sort, Integer page) throws Exception;
	
}
