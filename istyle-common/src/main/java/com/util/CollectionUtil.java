package com.util;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;

import java.util.Collection;
import java.util.Map;

/**
 * @Author:黄文伟
 * @description: 集合工具类
 * @Date:Created in 18:23 2018/10/22
 */
public final class CollectionUtil {
    /**
     * 判断 Collection 是否为空
     * @param collection
     * @return true，如果该 Collection 为空
     */
    public static boolean isEmpty(Collection<?> collection) {
        return CollectionUtils.isEmpty(collection);
    }

    /**
     * 判断 Collection 是否非空
     * @param collection
     * @return true，如果该 Collection 非空
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    /**
     * 判断 Map 是否为空
     * @param map
     * @return true，如果该 Map 为空
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return MapUtils.isEmpty(map);
    }

    /**
     * 判断 Map 是否非空
     * @param map
     * @return true，如果该 Map 非空
     */
    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }
}
