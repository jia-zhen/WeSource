package com.we.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "t_user")
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1425542765947962322L;

    /**
     * 账户状态
     */
    public static final String STATUS_VALID = "1";

    public static final String STATUS_LOCK = "0";
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long userId;

    private String username;

    private String password;

    private Long deptId;

    private String email;

    private String mobile;

    private String status;

    private Date crateTime;

    private Date modifyTime;

    private Date lastLoginTime;

    private String ssex;

    private String theme;

    private String avatar;

    private String description;


}