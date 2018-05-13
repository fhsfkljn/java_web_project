package com.chao.jd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chao.jd.po.ResultModel;
import com.chao.jd.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService service;

	@RequestMapping("list")
	public String list(String queryString, String catalog_name, String price, String sort, Integer page, Model model)
			throws Exception {
		ResultModel rm = service.getProducts(queryString, catalog_name, price, sort, page);

		// ����ѯ����ŵ�request��
		model.addAttribute("result", rm);

		// �����͵����ݻ���
		model.addAttribute("queryString", queryString);
		model.addAttribute("catalog_name", catalog_name);
		model.addAttribute("price", price);
		model.addAttribute("sort", sort);
		model.addAttribute("page", page);

		return "product_list";
	}
}
