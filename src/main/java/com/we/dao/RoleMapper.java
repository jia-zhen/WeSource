package com.we.dao;

import com.we.config.MyMapper;
import com.we.model.Role;

import java.util.List;

public interface RoleMapper extends MyMapper<Role> {


    List<Role> findUserRole(String userName);
}