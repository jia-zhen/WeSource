package com.we.service;

import com.we.model.RoleWithMenu;

public interface RoleMenuServie extends IService<RoleWithMenu> {

	void deleteRoleMenusByRoleId(String roleIds);

	void deleteRoleMenusByMenuId(String menuIds);
}
