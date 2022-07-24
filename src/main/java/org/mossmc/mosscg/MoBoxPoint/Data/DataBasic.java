package org.mossmc.mosscg.MoBoxPoint.Data;

import com.alibaba.fastjson.JSONObject;

public class DataBasic {
    /**
     * 数据基本格式：
     * {
     *     "main":123,
     *     "hunterGame":10,
     *     "hunterKill":12,
     *     "hunterWin":2,
     *     "hunterScore":106
     * }
     */
    public static JSONObject getBasicData() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("main",0);
        return jsonObject;
    }
}
