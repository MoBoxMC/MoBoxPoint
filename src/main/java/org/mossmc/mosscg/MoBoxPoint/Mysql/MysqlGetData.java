package org.mossmc.mosscg.MoBoxPoint.Mysql;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.mossmc.mosscg.MoBoxPoint.Cache.CacheUser;
import org.mossmc.mosscg.MoBoxPoint.Data.DataBasic;
import org.mossmc.mosscg.MoBoxPoint.Main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlGetData {
    //注意，这里数据库链接出错的时候返回null
    //没有该用户信息的时候返回一个新的JSON
    public static JSONObject getResult(String player) {
        if (CacheUser.userCacheMap.containsKey(player)) {
            return CacheUser.getCache(player);
        }
        String sql = "select * from "+Main.getConfig.getString("sqlTable")+" where name='"+player+"'";
        Connection connection = null;
        try {
            connection = MysqlConnection.getConnection();
            ResultSet set = connection.prepareStatement(sql).executeQuery();
            if (set.next()) {
                return JSON.parseObject(set.getString("data"));
            } else {
                return DataBasic.getBasicData();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
