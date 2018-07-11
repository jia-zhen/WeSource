package com.we.service.impl;

import com.we.dao.MenuMapper;
import com.we.model.Menu;
import com.we.service.MenuService;
import com.we.service.RoleMenuServie;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service("menuService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class MenuServiceImpl extends BaseService<Menu> implements MenuService {

	@Autowired
	private MenuMapper menuMapper;

	@Autowired
	private RoleMenuServie roleMenuService;

	@Override
	public List<Menu> findUserPermissions(String userName) {
		return null;
	}

	@Override
	public List<Menu> findUserMenus(String userName) {
		return null;
	}

	@Override
	public List<Menu> findAllMenus(Menu menu) {
		try {
			Example example = new Example(Menu.class);
			Criteria criteria = example.createCriteria();
			if (StringUtils.isNotBlank(menu.getMenuName())) {
				criteria.andCondition("menu_name=", menu.getMenuName());
			}
			if (StringUtils.isNotBlank(menu.getType())) {
				criteria.andCondition("type=", Long.valueOf(menu.getType()));
			}
			example.setOrderByClause("menu_id");
			return this.selectByExample(example);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}




	@Override
	public Menu findByNameAndType(String menuName, String type) {
		Example example = new Example(Menu.class);
		example.createCriteria().andCondition("lower(menu_name)=", menuName.toLowerCase()).andEqualTo("type",
				Long.valueOf(type));
		List<Menu> list = this.selectByExample(example);
		if (list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}
	}

	@Override
	@Transactional
	public void addMenu(Menu menu) {
		menu.setCreateTime(new Date());
		if (menu.getParentId() == null)
			menu.setParentId(0L);
		this.save(menu);
	}

	@Override
	@Transactional
	public void deleteMeuns(String menuIds) {
		List<String> list = Arrays.asList(menuIds.split(","));
		this.batchDelete(list, "menuId", Menu.class);
		this.roleMenuService.deleteRoleMenusByMenuId(menuIds);
		//this.menuMapper.changeToTop(list);
	}

	@Override
	public Menu findById(Long menuId) {
		return this.selectByKey(menuId);
	}

	@Override
	@Transactional
	public void updateMenu(Menu menu) {
		menu.setModifyTime(new Date());
		if (menu.getParentId() == null)
			menu.setParentId(0L);
		this.updateNotNull(menu);
	}

}
