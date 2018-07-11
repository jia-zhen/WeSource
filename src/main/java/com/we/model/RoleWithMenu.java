package com.we.model;

import lombok.Data;

@Data
public class RoleWithMenu {
    private Long roleId;

    private Long menuId;

    public RoleWithMenu(Long roleId, Long menuId) {
        this.roleId = roleId;
        this.menuId = menuId;
    }


}