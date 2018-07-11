package com.we.model;

import lombok.Data;

import java.util.Date;

@Data
public class Role {
    private Long roleId;

    private String roleName;

    private String remark;

    private Date createTime;

    private Date modifyTime;

    public Role(Long roleId, String roleName, String remark, Date createTime, Date modifyTime) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.remark = remark;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
    }

}