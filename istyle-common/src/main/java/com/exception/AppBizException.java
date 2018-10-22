package com.exception;

/**
 * @Author: 黄文伟
 * @description: 自定义业务异常
 * @Date:Created in 19:26 2018/10/22
 */
public class AppBizException extends RuntimeException {
    public AppBizException() {}

    public AppBizException(String message) {
        super(message);
    }

    public AppBizException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppBizException(Throwable cause) {
        super(cause);
    }

    public AppBizException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
