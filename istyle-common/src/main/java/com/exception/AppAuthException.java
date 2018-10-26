package com.exception;

/**
 * @Author: 黄文伟
 * @description: 自定义异常
 * @Date:Created in 19:22 2018/10/22
 */
public class AppAuthException extends RuntimeException {
    public AppAuthException() {}

    public AppAuthException(String message){
        super(message);
    }

    public AppAuthException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppAuthException(Throwable cause) {
        super(cause);
    }

    public AppAuthException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
