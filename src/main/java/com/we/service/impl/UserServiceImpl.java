package com.we.service.impl;

import com.we.dao.UserMapper;
import com.we.dao.UserWithRoleMapper;
import com.we.model.User;
import com.we.model.UserWithRole;
import com.we.service.UserRoleService;
import com.we.service.UserService;
import com.we.utils.MD5Utils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service("userService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserServiceImpl extends BaseService<User> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Autowired
    private UserWithRoleMapper userRoleMapper;

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public User findByName(String userName) {
        Example example = new Example(User.class);
        example.createCriteria().andCondition("lower(username)=", userName.toLowerCase());
        List<User> list = this.selectByExample(example);
        if (list.size() == 0) {
            return null;
        } else {
            return list.get(0);
        }
    }


    @Override
    @Transactional
    public void registUser(User user) {
        user.setCrateTime(new Date());
        user.setStatus(User.STATUS_VALID);
        user.setSsex(user.getSsex());
        user.setPassword(MD5Utils.encrypt(user.getUsername(), user.getPassword()));
        this.save(user);
        UserWithRole ur = new UserWithRole();
        ur.setUserId(user.getUserId());
        ur.setRoleId(3L);
        this.userRoleMapper.insert(ur);
    }


    @Override
    @Transactional
    public void addUser(User user, Long[] roles) {
        user.setCrateTime(new Date());
        user.setPassword(MD5Utils.encrypt(user.getUsername(), user.getPassword()));
        this.save(user);
        setUserRoles(user, roles);
    }

    private void setUserRoles(User user, Long[] roles) {
        for (Long roleId : roles) {
            UserWithRole ur = new UserWithRole();
            ur.setUserId(user.getUserId());
            ur.setRoleId(roleId);
            this.userRoleMapper.insert(ur);
        }
    }

    @Override
    @Transactional
    public void updateUser(User user, Long[] roles) {
        user.setPassword(null);
        user.setUsername(null);
        user.setModifyTime(new Date());
        this.updateNotNull(user);
        Example example = new Example(UserWithRole.class);
        example.createCriteria().andCondition("user_id=", user.getUserId());
        this.userRoleMapper.deleteByExample(example);
        setUserRoles(user, roles);
    }

    @Override
    @Transactional
    public void deleteUsers(String userIds) {
        List<String> list = Arrays.asList(userIds.split(","));
        this.batchDelete(list, "userId", User.class);

        this.userRoleService.deleteUserRolesByUserId(userIds);
    }

    @Override
    @Transactional
    public void updateLoginTime(String userName) {
        Example example = new Example(User.class);
        example.createCriteria().andCondition("lower(username)=", userName.toLowerCase());
        User user = new User();
        user.setLastLoginTime(new Date());
        this.userMapper.updateByExampleSelective(user, example);
    }

    @Override
    @Transactional
    public void updatePassword(String password) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Example example = new Example(User.class);
        example.createCriteria().andCondition("username=", user.getUsername());
        String newPassword = MD5Utils.encrypt(user.getUsername().toLowerCase(), password);
        user.setPassword(newPassword);
        this.userMapper.updateByExampleSelective(user, example);
    }

    @Override
    public UserWithRole findById(Long userId) {
        return null;
    }


    @Override
    public User selectByPrimaryKey(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }


}
