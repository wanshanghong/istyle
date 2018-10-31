package com.exception;

/**
 * @Author: 黄文伟
 * @description: 自定义未知异常
 * @Date:Created in 19:29 2018/10/22
 */
public class AppUnknownException extends RuntimeException {
    public AppUnknownException() {}

    public AppUnknownException(String message) {
        super(message);
    }

    public AppUnknownException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppUnknownException(Throwable cause) {
        super(cause);
    }

    public AppUnknownException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
