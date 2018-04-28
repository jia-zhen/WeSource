package com.we.ennums;

import lombok.Getter;

/**

    * @Description:
    * @author jiazhen
    * @date 2018/4/25 17:14
    */
@Getter
public enum ResultEnum {

    SUCCESS(0, "成功");

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
