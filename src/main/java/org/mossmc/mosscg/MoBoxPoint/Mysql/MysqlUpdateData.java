package org.mossmc.mosscg.MoBoxPoint.Mysql;

import com.alibaba.fastjson.JSONObject;
import org.bukkit.scheduler.BukkitRunnable;
import org.mossmc.mosscg.MoBoxPoint.BasicInfo;
import org.mossmc.mosscg.MoBoxPoint.Cache.CacheUser;
import org.mossmc.mosscg.MoBoxPoint.Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlUpdateData {
    public static void asyncUpdateData(JSONObject data,String player) {
        BukkitRunnable runnable = new BukkitRunnable() {
            @Override
            public void run() {
                updateData(data, player);
            }
        };
        runnable.runTaskAsynchronously(BasicInfo.instance);
    }
    public static void updateData(JSONObject data,String player) {
        String sqlCheckExist = "select * from "+Main.getConfig.getString("sqlTable")+" where name='"+player+"'";
        String sqlUpdate = "update "+Main.getConfig.getString("sqlTable")+" set data='"+data+"' WHERE name='"+player+"'";;
        String sqlInsert = "insert into "+Main.getConfig.getString("sqlTable")+" (name,data) values (?,?)";
        Connection connection = null;
        try {
            connection = MysqlConnection.getConnection();
            ResultSet set = connection.prepareStatement(sqlCheckExist).executeQuery();
            if (set.next()) {
                connection.prepareStatement(sqlUpdate).execute();
            } else {
                PreparedStatement statement = connection.prepareStatement(sqlInsert);
                statement.setString(1,player);
                statement.setString(2,String.valueOf(data));
                statement.executeUpdate();
            }
            CacheUser.inputCache(player,data);
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
    }
}
