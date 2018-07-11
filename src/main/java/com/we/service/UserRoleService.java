package com.we.service;

import com.we.model.UserWithRole;

public interface UserRoleService extends IService<UserWithRole> {

	void deleteUserRolesByRoleId(String roleIds);

	void deleteUserRolesByUserId(String userIds);
}
