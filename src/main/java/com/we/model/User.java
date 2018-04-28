package com.we.model;

import lombok.Data;

@Data
public class User {
    private Integer userId;

    private String userName;

    private String password;

    private String deptId;

    private String email;

    private String mobile;

    private String status;

    private String crateTime;

    private String modifyTime;

    private String lastLoginTime;

    private String ssex;

    private String avatar;

    private String description;

    public User(Integer userId, String userName, String password, String deptId, String email, String mobile, String status, String crateTime, String modifyTime, String lastLoginTime, String ssex, String avatar, String description) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.deptId = deptId;
        this.email = email;
        this.mobile = mobile;
        this.status = status;
        this.crateTime = crateTime;
        this.modifyTime = modifyTime;
        this.lastLoginTime = lastLoginTime;
        this.ssex = ssex;
        this.avatar = avatar;
        this.description = description;
    }
    public  User(){

    }
}