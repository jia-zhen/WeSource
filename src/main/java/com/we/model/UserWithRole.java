package com.we.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "t_user_role")
public class UserWithRole extends  User {


    private static final long serialVersionUID = -7041805173926321392L;

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