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

	// ��ѯ������Ʒ
	// model�൱��application�����
	@RequestMapping("list")
	public String list(Model model) {
		List<Items> list = itemsService.findAll();
		model.addAttribute("itemsList", list);
		return "itemsList";
	}

	// ��ת���޸�ҳ��
	@RequestMapping("edit")
	public String edit(Integer id, Model model) {
		// ����Id��ѯ��Ʒ
		Items items = itemsService.findById(id);
		// ҳ�����
		model.addAttribute("item", items);
		return "editItem";
	}

	// �޸���Ʒ��Ϣ
	@RequestMapping("saveOrUpdate")
	public String saveOrUpdate(Items items) {
		itemsService.saveOrUpdate(items);
		return "redirect:list.do";
	}

	// ����Id����ɾ��
	@RequestMapping("deleteByID")
	public String deleteByID(Integer id) {
		itemsService.deleteByID(id);
		return "redirect:list.do";
	}

	// ����ɾ��
	@RequestMapping("deleteByIds")
	public String deleteByIds(Integer[] id) {
		for (Integer ids : id) {
			itemsService.deleteByID(ids);
		}
		return "redirect: list.do";
	}
}
