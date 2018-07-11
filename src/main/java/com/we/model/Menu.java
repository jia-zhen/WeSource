package com.we.model;

import lombok.Data;

import java.util.Date;

@Data
public class Menu {
    private Long menuId;

    private Long parentId;

    private String menuName;

    private String url;

    private String icon;

    private String type;

    private Long orderNum;

    private Date createTime;

    private Date modifyTime;

    private String perms;

    public Menu(Long menuId, Long parentId, String menuName, String url, String icon, String type, Long orderNum, Date createTime, Date modifyTime, String perms) {
        this.menuId = menuId;
        this.parentId = parentId;
        this.menuName = menuName;
        this.url = url;
        this.icon = icon;
        this.type = type;
        this.orderNum = orderNum;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
        this.perms = perms;
    }


}