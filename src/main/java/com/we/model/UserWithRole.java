package com.we.model;

import lombok.Data;

import java.util.List;

@Data
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