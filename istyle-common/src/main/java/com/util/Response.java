package com.util;

import com.enums.ErrCode;

/**
 * @Author: 黄文伟
 * @description: 统一响应类
 * @Date:Created in 19:43 2018/10/22
 */
public class Response {
    /**
     * 返回成功响应
     *
     * <pre>
     *      {"errCode":0, "result":{"key":"value"}}
     * </pre>
     *
     * @param result
     * @return Response
     */
    public static Response ok(Object result) {
        return new Response(result);
    }

    /**
     * 返回成功响应，不附带数据
     *
     * <pre>
     *     {"errCode":0}
     * </pre>
     *
     * @return Response
     */
    public static Response ok() {
        return new Response(null);
    }

    /**
     * 系统状态码，0：成功
     */
    protected int errCode = ErrCode.NO_ERR.getValue();

    /**
     * 返回响应，身份验证错误,不附带数据
     *
     * <pre>
     *     {"errCode":100, "msg":"校验错误，请登录xxxx"}
     * </pre>
     *
     * @param msg 消息提示
     * @return Response
     */
    public static Response errAuth(String msg) {
        return errAuth(msg, null);
    }

    /**
     * 返回响应，身份验证错误
     *
     * <pre>
     *     {"errCode":100, "msg":"校验错误，请登录xxxx"}
     * </pre>
     *
     * @param msg 消息提示
     * @return Response
     */
    public static Response errAuth(String msg, Object result) {
        return new Response(ErrCode.AUTH_ERR.getValue(), msg, result);
    }

    /**
     * 返回响应，遇到未知错误，不附带数据
     *
     * @param msg 未知错误
     * @return Response
     */
    public static Response errUnknown(String msg) {
        return errUnknown(msg, null);
    }

    /**
     * 返回响应，遇到未知错误
     *
     * @param msg 未知错误
     * @return Response
     */
    private static Response errUnknown(String msg, Object result) {
        return new Response(ErrCode.UNKNOWN_ERROR.getValue(), msg, result);
    }

    /**
     * 返回响应，参数错误，不附带数据
     *
     * <pre>
     *  {"errcode":102, "msg":"校验错误，请登录xxxx"}
     * </pre>
     *
     * @param msg 消息提示
     * @return Response
     */
    public static Response errParams(String msg) {
        return errParams(msg, null);
    }

    /**
     * 返回响应，参数错误，不附带数据
     *
     * <pre>
     *  {"errcode":102, "msg":"校验错误，请登录xxxx"}
     * </pre>
     *
     * @param msg 消息提示
     * @return Response
     */
    public static Response errParams(String msg, Object result) {
        return new Response(ErrCode.PARAMS_ERR.getValue(), msg, result);
    }

    /**
     * 业务处理错误，可显示，不附带数据
     *
     * <pre>
     *  {"errCode":103, "msg":"xx失败"}
     * </pre>
     *
     * @param msg 消息提示
     * @return Response
     */
    public static Response errBiz(String msg) {
        return errBiz(msg, null);
    }

    /**
     * 业务处理错误，可显示
     *
     * <pre>
     *  {"errCode":103, "msg":"xx失败"}
     * </pre>
     *
     * @param msg 消息提示
     * @return Response
     */
    public static Response errBiz(String msg, Object result) {
        return new Response(ErrCode.BIZ_ERR.getValue(), msg, result);
    }

    /**
     * 返回响应，系统处理异常，不附带数据
     *
     * <pre>
     *  {"errCode":400, "msg":"运行异常"}
     * </pre>
     *
     * @param msg 消息提示
     * @return Response
     */
    public static Response errSys(String msg) {
        return errSys(msg, null);
    }

    /**
     * 返回响应，系统处理异常
     *
     * <pre>
     *  {"errCode":400, "msg":"运行异常"}
     * </pre>
     *
     * @param msg 消息提示
     * @return Response
     */
    public static Response errSys(String msg, Object result) {
        return new Response(ErrCode.SYS_ERR.getValue(), msg, result);
    }



    /**
     * 返回响应，权限错误：冻结，不附带数据
     *
     * <pre>
     *  {"errCode":120, "msg":"权限错误：冻结"}
     * </pre>
     *
     * @param msg 消息提示
     * @return Response
     */
    public static Response errFrozen(String msg) {
        return errFrozen(msg, null);
    }

    /**
     * 返回响应，权限错误：冻结
     *
     * <pre>
     *  {"errCode":120, "msg":"权限错误：冻结"}
     * </pre>
     *
     * @param msg 消息提示
     * @return Response
     */
    public static Response errFrozen(String msg, Object result) {
        return new Response(ErrCode.FROZENED_ERR.getValue(), msg, result);
    }

    /**
     * 返回响应，权限错误：禁言，不附带数据
     *
     * <pre>
     *  {"errCode":121, "msg":"权限错误：禁言"}
     * </pre>
     *
     * @param msg 消息提示
     * @return Response
     */
    public static Response errForbidden(String msg) {
        return errForbidden(msg, null);
    }

    /**
     * 返回响应，权限错误：禁言
     *
     * <pre>
     *  {"errCode":121, "msg":"权限错误：禁言"}
     * </pre>
     *
     * @param msg 消息提示
     * @return Response
     */
    public static Response errForbidden(String msg, Object result) {
        return new Response(ErrCode.FORBIDDEN_ERR.getValue(), msg, result);
    }

    /**
     * 返回响应，权限错误，是指对某接口资源的访问或操作权限，不附带数据
     *
     * <pre>
     *  {"errCode":120, "msg":"权限限制"}
     * </pre>
     *
     * @param msg 消息提示
     * @return Response
     */
    public static Response errPermission(String msg) {
        return errPermission(msg, null);
    }

    /**
     * 返回响应，权限错误，是指对某接口资源的访问或操作权限
     *
     * <pre>
     *  {"errCode":120, "msg":"权限限制"}
     * </pre>
     *
     * @param msg 消息提示
     * @return Response
     */
    public static Response errPermission(String msg, Object result) {
        return new Response(ErrCode.FROZENED_ERR.getValue(), msg, result);
    }

    /**
     * 返回响应，自定义错误码和消息
     *
     * @param errCode 指定的错误码
     * @param msg 消息提示
     * @return Response
     */
    public static Response build(Integer errCode, String msg) {
        return build(errCode, msg, null);
    }

    /**
     * 返回响应，自定义错误码和消息，附带data
     *
     * @param errCode 指定的错误码
     * @param msg 消息提示
     * @return Response
     */
    public static Response build(Integer errCode, String msg, Object result) {
        return new Response(errCode, msg, result);
    }

    /**
     * 系统消息
     */
    protected String msg = "ok";

    /**
     * 返回数据
     */
    public Object result;

    public Response(Object result) {
        this.result = result;
    }

    public Response(int errCode, String msg, Object result) {
        this.errCode = errCode;
        this.msg = msg;
        this.result = result;
    }

    public Response(int errCode, String msg) {
        this.errCode = errCode;
        this.msg = msg;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
