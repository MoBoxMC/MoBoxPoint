package org.mossmc.mosscg.MoBoxPoint.Cache;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class CacheUser {
    public static Map<String,JSONObject> userCacheMap = new HashMap<>();

    public static JSONObject getCache(String player) {
        if (!userCacheMap.containsKey(player)) {
            return null;
        }
        return userCacheMap.get(player);
    }

    public static void inputCache(String player,JSONObject data) {
        userCacheMap.put(player,data);
    }

    public static void removeCache(String player) {
        userCacheMap.remove(player);
    }
}
