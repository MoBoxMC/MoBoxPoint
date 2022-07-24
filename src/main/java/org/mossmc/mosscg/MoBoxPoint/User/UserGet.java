package org.mossmc.mosscg.MoBoxPoint.User;

import com.alibaba.fastjson.JSONObject;
import org.mossmc.mosscg.MoBoxPoint.Main;
import org.mossmc.mosscg.MoBoxPoint.Mysql.MysqlGetData;

public class UserGet {
    public static JSONObject getUserData(String player) {
        JSONObject jsonObject = MysqlGetData.getResult(player);
        if (Main.getConfig.getBoolean("debug")) {
            Main.logger.info(String.valueOf(jsonObject));
        }
        return jsonObject;
    }

    public static int getUserScore(String player,String key) {
        JSONObject jsonObject = getUserData(player);
        if (jsonObject.containsKey(key)) {
            return jsonObject.getInteger(key);
        } else {
            return 0;
        }
    }
}
