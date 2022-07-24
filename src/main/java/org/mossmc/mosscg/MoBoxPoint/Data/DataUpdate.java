package org.mossmc.mosscg.MoBoxPoint.Data;

import com.alibaba.fastjson.JSONObject;

public class DataUpdate {
    public static void addScore(JSONObject data,String key,int score) {
        int newScore;
        if (data.containsKey(key)) {
            newScore = data.getInteger(key)+score;
            data.remove(key);
        } else {
            newScore = score;
        }
        data.put(key,newScore);
    }
}
