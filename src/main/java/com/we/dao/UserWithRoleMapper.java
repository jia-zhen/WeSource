package com.we.dao;

import com.we.model.UserWithRole;

public interface UserWithRoleMapper {
    int insert(UserWithRole record);

    int insertSelective(UserWithRole record);
}