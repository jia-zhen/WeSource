package com.we.dao;

import com.we.config.MyMapper;
import com.we.model.Menu;

import java.util.List;

public interface MenuMapper extends MyMapper<Menu> {

    List<Menu> findUserPermissions(String userName);
}