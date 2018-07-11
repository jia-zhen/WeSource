package com.we.model;

import lombok.Data;

import java.util.Date;
@Data
public class User {

    /**
     * 账户状态
     */
    public static final String STATUS_VALID = "1";

    public static final String STATUS_LOCK = "0";

    public static final String DEFAULT_THEME = "green";

    public static final String DEFAULT_AVATAR = "default.jpg";

    /**
     * 性别
     */
    public static final String SEX_MALE = "0";

    public static final String SEX_FEMALE = "1";

    public static final String SEX_UNKNOW = "2";


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

    public User() {
        super();
    }

    public User(Long userId, String username, String password, Long deptId, String email, String mobile, String status, Date crateTime, Date modifyTime, Date lastLoginTime, String ssex, String theme, String avatar, String description) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.deptId = deptId;
        this.email = email;
        this.mobile = mobile;
        this.status = status;
        this.crateTime = crateTime;
        this.modifyTime = modifyTime;
        this.lastLoginTime = lastLoginTime;
        this.ssex = ssex;
        this.theme = theme;
        this.avatar = avatar;
        this.description = description;
    }

}