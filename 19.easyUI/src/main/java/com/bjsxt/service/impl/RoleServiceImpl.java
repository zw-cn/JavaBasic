package com.bjsxt.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjsxt.mapper.MenuMapper;
import com.bjsxt.mapper.RoleMapper;
import com.bjsxt.pojo.EasyUIDatagrid;
import com.bjsxt.pojo.Menu;
import com.bjsxt.pojo.Role;
import com.bjsxt.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Resource
	private RoleMapper roleMapper;
	@Resource
	private MenuMapper menuMapper;

	@Override
	public EasyUIDatagrid showRole(int pageSize, int pageNumber) {
		EasyUIDatagrid datagrid = new EasyUIDatagrid();
		datagrid.setRows(roleMapper.selByPage(pageSize*(pageNumber-1), pageSize));
		datagrid.setTotal(roleMapper.selCount());
		return datagrid;
	}

	@Override
	public int update(Role role) {
		return roleMapper.updRole(role);
	}

	@Override
	public List<Menu> showPrivilege(int roleid) {
		//当前角色对应的id
		List<Menu> listParent = menuMapper.selByPidRid(0, roleid);
		List<Menu> listRole = new ArrayList<>();
		for (Menu menu : listParent) {
			listRole.addAll(menuMapper.selByPidRid(menu.getId(), roleid));
		}
		//全部一级菜单
		List<Menu> listAll = menuMapper.selAll();
		for (Menu menu : listAll) {
			//不能设置以及菜单
//			for (Menu parent : listParent) {
//				if(parent.getId()==menu.getId()){
//					menu.setChecked(true);
//				}
//			}
			List<Menu> listChildren = menuMapper.selByPid(menu.getId());
			for (Menu menu1 : listChildren) {
				for (Menu menu2 : listRole) {
					if(menu2.getId()==menu1.getId()){
						menu1.setChecked(true);
					}
				}
			}
			menu.setChildren(listChildren);
		}
		return listAll;
	}
	
}
