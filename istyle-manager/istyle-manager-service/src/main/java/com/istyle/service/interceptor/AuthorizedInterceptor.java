package com.istyle.service.interceptor;

import com.alibaba.fastjson.JSON;
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
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @Author: 黄文伟
 * @description: 拦截器，对 stoken 进行校验
 * @Date:Created in 20:53 2018/10/22
 */
public class AuthorizedInterceptor implements HandlerInterceptor {
    private static Logger logger = LoggerFactory.getLogger(AuthorizedInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String param;
        BufferedReader streamReader = new BufferedReader( new InputStreamReader(request.getInputStream(), "UTF-8"));
        StringBuilder responseStrBuilder = new StringBuilder();
        String inputStr;
        while ((inputStr = streamReader.readLine()) != null) {
            responseStrBuilder.append(inputStr);
        }
        JSONObject jsonObject = JSONObject.parseObject(responseStrBuilder.toString());
        param= jsonObject.toJSONString();
        Map map = (Map) JSON.parse(param);
        String stoken = (String) map.get("stoken");

        if (StringUtil.isEmpty(stoken)) {
            responseMessage(response, response.getWriter(), Response.errAuth("stoken错误，校验失败"));
            throw new AppAuthException("校验失败，stoken为空,uri为："+ request.getRequestURI());
        } else {
            TbUser user = JWT.unsign(stoken, TbUser.class);
            if(user==null){
                responseMessage(response, response.getWriter(), Response.errAuth("stoken错误，校验失败"));
                throw new AppAuthException("校验失败，用户不存在");
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