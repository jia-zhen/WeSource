package com.we.model;

import lombok.Data;

import javax.persistence.Table;
import java.util.List;

@Data
@Table(name = "t_user_role")
public class UserWithRole {


    private Long userId;

    private Long roleId;

    private List roleIds;

    public UserWithRole() {

    }


    public UserWithRole(Long userId, Long roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }


}