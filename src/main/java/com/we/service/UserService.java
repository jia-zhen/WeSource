package com.we.service;

import com.we.model.User;
import org.springframework.beans.factory.annotation.Autowired;


public interface UserService {


    int register(User user);
}
