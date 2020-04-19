package com.bjsxt.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjsxt.pojo.EasyUIDatagrid;
import com.bjsxt.pojo.Menu;
import com.bjsxt.pojo.Role;
import com.bjsxt.service.RoleService;

@Controller
@RequestMapping("page")
public class RoleController {
	@Resource
	private RoleService roleServiceImpl;
	@RequestMapping("showRole")
	@ResponseBody
	public EasyUIDatagrid showRole(@RequestParam(defaultValue="2")int rows,@RequestParam(defaultValue="1")int page){
		return roleServiceImpl.showRole(rows, page);
	}
	
	@RequestMapping("update")
	@ResponseBody
	public int update(Role role){
		int index = roleServiceImpl.update(role);
		return index;
	}
	@RequestMapping("showPrivilege")
	@ResponseBody
	public List<Menu> showPrivilege(int id){
		return roleServiceImpl.showPrivilege(id);
	}
}
