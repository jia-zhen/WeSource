package com.we.dao;

import com.we.model.RoleWithMenu;

public interface RoleWithMenuMapper {
    int insert(RoleWithMenu record);

    int insertSelective(RoleWithMenu record);
}