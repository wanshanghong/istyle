package com.exception;

import com.util.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Author: 黄文伟
 * @description: 异常处理类
 * @Date:Created in 19:22 2018/10/22
 */
@ControllerAdvice
public class AppExceptionHandler {
    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Response exceptionHandler(Exception e){
        if (e instanceof AppAuthException) {
            return Response.errAuth(e.getMessage());
        } else if (e instanceof AppParamsException){
            return Response.errParams(e.getMessage());
        }else if (e instanceof AppBizException){
            return Response.errBiz(e.getMessage());
        }else {
            return Response.errUnknown(e.getMessage());
        }
    }
}
