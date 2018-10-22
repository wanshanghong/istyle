package com.exception;

/**
 * @Author: 黄文伟
 * @description: 自定义参数异常
 * @Date:Created in 19:28 2018/10/22
 */
public class AppParamsException extends RuntimeException {
    public AppParamsException() {}

    public AppParamsException(String message) {
        super(message);
    }

    public AppParamsException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppParamsException(Throwable cause) {
        super(cause);
    }

    public AppParamsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
