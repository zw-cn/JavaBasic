package com.bjsxt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjsxt.mapper.MenuMapper;
import com.bjsxt.pojo.Attributes;
import com.bjsxt.pojo.Menu;
import com.bjsxt.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {
	@Resource
	private MenuMapper menuMapper;

	@Override
	public List<Menu> selAll() {
		List<Menu> list = menuMapper.selAll();
		for (Menu menu : list) {
			List<Menu> listChildren = menuMapper.selByPid(menu.getId());
			for (Menu child : listChildren) {
				Attributes att = new Attributes();
				att.setFilename(child.getFilename());
				child.setAttributes(att);
			}
			menu.setChildren(listChildren);
		}
		return list;
	}
}
