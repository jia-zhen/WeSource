package com.we.service.impl;

import com.we.dao.RoleMapper;
import com.we.dao.RoleMenuMapper;
import com.we.model.Role;
import com.we.model.RoleWithMenu;
import com.we.service.RoleMenuServie;
import com.we.service.RoleService;
import com.we.service.UserRoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service("roleService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class RoleServiceImpl extends BaseService<Role> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private RoleMenuServie roleMenuService;

    @Override
    public List<Role> findUserRole(String userName) {
        return roleMapper.findUserRole(userName);
    }

    @Override
    public List<Role> findAllRole(Role role) {
       return null;
    }

    @Override
    public Role findByName(String roleName) {
        return null;
    }

    @Override
    @Transactional
    public void addRole(Role role, Long[] menuIds) {
        role.setCreateTime(new Date());
        this.save(role);
        setRoleMenus(role, menuIds);
    }

    private void setRoleMenus(Role role, Long[] menuIds) {

    }

    @Override
    @Transactional
    public void deleteRoles(String roleIds) {
        List<String> list = Arrays.asList(roleIds.split(","));
        this.batchDelete(list, "roleId", Role.class);

        this.roleMenuService.deleteRoleMenusByRoleId(roleIds);
        this.userRoleService.deleteUserRolesByRoleId(roleIds);

    }

    @Override
    public RoleWithMenu findRoleWithMenus(Long roleId) {
        return null;
    }

    @Override
    @Transactional
    public void updateRole(Role role, Long[] menuIds) {
        role.setModifyTime(new Date());
        this.updateNotNull(role);
        Example example = new Example(RoleWithMenu.class);
        example.createCriteria().andCondition("role_id=", role.getRoleId());
        this.roleMenuMapper.deleteByExample(example);
        setRoleMenus(role, menuIds);
    }

}
