package com.we.service;

import com.we.model.User;
import com.we.model.UserWithRole;

import java.util.List;

public interface UserService extends IService<User> {

	UserWithRole findById(Long userId);

	User selectByPrimaryKey(Long userId);
	
	User findByName(String userName);

	void registUser(User user);

	void addUser(User user, Long[] roles);

	void updateUser(User user, Long[] roles);
	
	void deleteUsers(String userIds);

	void updateLoginTime(String userName);
	
	void updatePassword(String password);
	

}
