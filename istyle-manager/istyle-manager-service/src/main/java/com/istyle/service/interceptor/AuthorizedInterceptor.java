package com.istyle.service.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.exception.AppAuthException;
import com.istyle.pojo.TbUser;
import com.util.JWT;
import com.util.Response;
import com.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @Author: 黄文伟
 * @description: 拦截器，对 stoken 进行校验
 * @Date:Created in 20:53 2018/10/22
 */
public class AuthorizedInterceptor implements HandlerInterceptor {
    private final Logger logger = LoggerFactory.getLogger(AuthorizedInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("正在校验stoken。。。.");
        String stoken = request.getParameter("stoken");
        System.out.println("stoken: " + stoken);
        logger.info("stoken:{}", stoken);

        if (StringUtil.isEmpty(stoken)) {
            responseMessage(response, response.getWriter(), Response.errAuth("stoken错误，校验失败"));
            throw new AppAuthException("校验失败");
        } else {
            TbUser user = JWT.unsign(stoken, TbUser.class);
            if(user==null){
                responseMessage(response, response.getWriter(), Response.errAuth("stoken错误，校验失败"));
                throw new AppAuthException("校验失败");
            }
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("afterCompletion");
    }

    /**
     * 请求不通过，返回错误信息给客户端
     */
    private void responseMessage(HttpServletResponse response, PrintWriter out, Response responseData) {
        response.setContentType("application/json;charset=utf-8");
        String json = JSONObject.toJSONString(responseData);
        response.setCharacterEncoding("utf-8");
        logger.info("json:{}", json);
        out.print(json);
        out.flush();
        out.close();
    }
}
