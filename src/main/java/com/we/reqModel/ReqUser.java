package com.we.reqModel;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class ReqUser {

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

    @NotBlank(message = "角色信息不能为空")
    private String  roles;


}

