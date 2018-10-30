package com.istyle.service.util;

import com.istyle.pojo.TbUser;

/**
 * @Author: 黄文伟
 * @description:
 * @Date:Created in 21:45 2018/10/24
 */
public class SessionUtil {
    private static ThreadLocal<TbUser> userThreadLocal = new ThreadLocal<>();

    public static void setUserThreadLocal(TbUser user) {
        userThreadLocal.set(user);
    }

    public static TbUser getUserThreadLocal() {
        return userThreadLocal.get();
    }

    public static void clear() {
        userThreadLocal.remove();
    }
}
