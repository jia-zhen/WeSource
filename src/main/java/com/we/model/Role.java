package com.we.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
public class Role {

    @Id
    @GeneratedValue(generator = "JDBC")
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