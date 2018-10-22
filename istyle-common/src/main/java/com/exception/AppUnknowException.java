package com.exception;

/**
 * @Author: 黄文伟
 * @description: 自定义未知异常
 * @Date:Created in 19:29 2018/10/22
 */
public class AppUnknowException extends RuntimeException {
    public AppUnknowException() {}

    public AppUnknowException(String message) {
        super(message);
    }

    public AppUnknowException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppUnknowException(Throwable cause) {
        super(cause);
    }

    public AppUnknowException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
