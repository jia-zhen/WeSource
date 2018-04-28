package com.we.service.impl;

import com.we.dao.UserMapper;
import com.we.model.User;
import com.we.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {



    @Autowired
    private UserMapper userDao;


    @Override
    public int register(User user) {
        return userDao.insert(user);
    }
}
