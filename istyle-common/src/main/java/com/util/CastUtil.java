package com.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author:黄文伟
 * @description: 转型操作工具类
 * @Date:Created in 17:05 2018/10/22
 */
public final class CastUtil {
    /**
     * 转为String型
     * @param obj
     * @return String
     */
    public static String castString(Object obj) {
        return CastUtil.castString(obj, "");
    }

    /**
     * 转为String型（提供默认值）
     * @param obj
     * @param defaultValue
     * @return String
     */
    public static String castString(Object obj, String defaultValue) {
        return obj != null ? String.valueOf(obj) : defaultValue;
    }

    /**
     * 转为 double 型
     * @param obj
     * @return double
     */
    public static double castDouble(Object obj) {
        return CastUtil.castDouble(obj, 0);
    }

    /**
     * 转为 double 型（提供默认值）
     * @param obj
     * @param defaultValue
     * @return double
     */
    public static double castDouble(Object obj, double defaultValue) {
        double doubleValue = defaultValue;
        if (obj != null) {
            String strValue = castString(obj);
            if (StringUtils.isNotEmpty(strValue)) {
                try {
                    doubleValue = Double.parseDouble(strValue);
                } catch (NumberFormatException e) {
                    doubleValue = defaultValue;
                }
            }
        }
        return doubleValue;
    }

    /**
     * 转为 long 型
     * @param obj
     * @return long
     */
    public static long castLong(Object obj) {
        return CastUtil.castLong(obj, 0);
    }

    /**
     * 转为 long 型（提供默认值）
     * @param obj
     * @param defaultValue
     * @return long
     */
    public static long castLong (Object obj, long defaultValue) {
        long longValue = defaultValue;
        if (obj != null) {
            String strValue = castString(obj);
            if (StringUtils.isNotEmpty(strValue)) {
                try {
                    longValue = Long.parseLong(strValue);
                } catch (NumberFormatException e) {
                    longValue = defaultValue;
                }
            }
        }
        return longValue;
    }

    /**
     * 转为 int 型
     * @param obj
     * @return int
     */
    public static int castInt(Object obj) {
        return CastUtil.castInt(obj, 0);
    }

    /**
     * 转为 int 型（提供默认值）
     * @param obj
     * @param defaultValue
     * @return int
     */
    public static int castInt(Object obj, int defaultValue) {
        int intValue = defaultValue;
        if (obj != null) {
            String strValue = castString(obj);
            if (StringUtils.isNotEmpty(strValue)) {
                try {
                    intValue = Integer.parseInt(strValue);
                } catch (NumberFormatException e) {
                    intValue = defaultValue;
                }
            }
        }
        return intValue;
    }

    /**
     * 转为 boolean 型
     * @param obj
     * @return boolean
     */
    public static boolean castBoolean(Object obj) {
        return CastUtil.castBoolean(obj, false);
    }

    /**
     * 转为 boolean 型(提供默认值）
     * @param obj
     * @param defaultValue
     * @return boolean
     */
    public static boolean castBoolean(Object obj, boolean defaultValue) {
        boolean booleanValue = defaultValue;
        if (obj != null) {
            booleanValue = Boolean.parseBoolean(castString(obj));
        }
        return booleanValue;
    }
}
