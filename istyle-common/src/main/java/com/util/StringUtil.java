package com.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author:黄文伟
 * @description: 字符串工具类
 * @Date:Created in 18:13 2018/10/22
 */
public final class StringUtil {
    /**
     * 判断字符串是否为空
     * @param str
     * @return true为空，false为非空
     */
    public static boolean isEmpty(String str) {
        if (str != null) {
            str = str.trim();
        }
        return StringUtils.isEmpty(str);
    }

    /**
     * 判断字符串是否非空
     * @param str
     * @return true为非空，false为空
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
}
