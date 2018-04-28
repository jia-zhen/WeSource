package com.we.dao;

import com.we.model.User;
import com.we.utils.DateUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UserMapperTest {


    @Autowired
    private UserMapper userMapper;

    @Test
    public void register() {
        User u=new User(2,"jiazhen","Password123","1","123@qq.com","13297905801","00",DateUtil.getDateTime(),"","","","","");

        int i=userMapper.insert(u) ;
        System.out.print(i);

    }


}