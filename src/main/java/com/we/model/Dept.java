package com.we.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


@Table(name = "t_dept")
@Data
public class Dept implements Serializable {

    private static final long serialVersionUID = -1300711243968109878L;
    /**
     * 部门ID
     */
    @Id
    @Column(name = "DEPT_ID")
    private Long deptId;

    /**
     * 上级部门ID
     */
    @Column(name = "PARENT_ID")
    private Long parentId;

    /**
     * 部门名称
     */
    @Column(name = "DEPT_NAME")
    private String deptName;

    /**
     * 排序
     */
    @Column(name = "ORDER_NUM")
    private Long orderNum;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    private Date createTime;


}