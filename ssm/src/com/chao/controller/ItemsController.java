package com.chao.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chao.domain.Items;
import com.chao.service.ItemsService;

@Controller
@RequestMapping("/items")
public class ItemsController {
	@Resource
	private ItemsService itemsService;

	// 查询所有商品
	// model相当于application域对象
	@RequestMapping("list")
	public String list(Model model) {
		List<Items> list = itemsService.findAll();
		model.addAttribute("itemsList", list);
		return "itemsList";
	}

	// 跳转到修改页面
	@RequestMapping("edit")
	public String edit(Integer id, Model model) {
		// 根据Id查询商品
		Items items = itemsService.findById(id);
		// 页面回显
		model.addAttribute("item", items);
		return "editItem";
	}

	// 修改商品信息
	@RequestMapping("saveOrUpdate")
	public String saveOrUpdate(Items items) {
		itemsService.saveOrUpdate(items);
		return "redirect:list.do";
	}

	// 根据Id进行删除
	@RequestMapping("deleteByID")
	public String deleteByID(Integer id) {
		itemsService.deleteByID(id);
		return "redirect:list.do";
	}

	// 批量删除
	@RequestMapping("deleteByIds")
	public String deleteByIds(Integer[] id) {
		for (Integer ids : id) {
			itemsService.deleteByID(ids);
		}
		return "redirect: list.do";
	}
}
