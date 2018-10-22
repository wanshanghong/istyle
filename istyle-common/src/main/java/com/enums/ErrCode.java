package com.enums;

/**
 * @Author: 黄文伟
 * @description: 异常状态码枚举类
 * @Date:Created in 19:39 2018/10/22
 */
public enum ErrCode {
    AUTH_ERR(100),
    PARAMS_ERR(102),
    UNKNOWN_ERROR(500),
    BIZ_ERR(103),
    SYS_ERR(400),
    FORBIDDEN_ERR(121),
    FROZENED_ERR(120),
    NO_ERR(0);
    private int value;

    ErrCode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
