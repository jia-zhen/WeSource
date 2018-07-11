package com.we.model;

import lombok.Data;

import java.util.Date;

@Data
public class Dept {
    private Long deptId;

    private Long parentId;

    private String deptName;

    private Long orderNum;

    private Date createTime;

    public Dept() {
    }

    public Dept(Long deptId, Long parentId, String deptName, Long orderNum, Date createTime) {
        this.deptId = deptId;
        this.parentId = parentId;
        this.deptName = deptName;
        this.orderNum = orderNum;
        this.createTime = createTime;
    }


}