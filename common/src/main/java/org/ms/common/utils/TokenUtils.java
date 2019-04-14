package org.ms.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.ToDoubleBiFunction;

/**
 * 临时且唯一的值
 * 
 * @author Zhenglai
 * @since 2019-04-14 18:11
 */
public class TokenUtils {

    private static Map<String, Object> tokenMap = new ConcurrentHashMap<>();

    // TODO 2019-04-14 Zhenglai Zhang: improve logic and token generation
    public static synchronized String getToken() {
        // 分布式环境下通过全局ID实现
        var s = "token-" + System.currentTimeMillis();
        // 一般key存userId
        tokenMap.put(s, s);
        return s;
    }

    public static synchronized boolean foundToken(String tokenKey) {
        var token = (String)tokenMap.get(tokenKey);
        if (StringUtils.isBlank(token)) {
            return false;
        }

        tokenMap.remove(token);
        return true;
    }
}
