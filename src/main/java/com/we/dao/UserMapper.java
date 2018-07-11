package com.we.dao;

import com.we.model.User;
import com.we.model.UserWithRole;
import lombok.Data;

import java.util.List;

public interface UserMapper  extends MyMapper<User>{
    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> findUserWithDept(User user);

    List<UserWithRole> findUserWithRole(Long userId);


}