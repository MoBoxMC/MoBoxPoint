package org.mossmc.mosscg.MoBoxPoint.User;

import com.alibaba.fastjson.JSONObject;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.mossmc.mosscg.MoBoxPoint.Data.DataUpdate;
import org.mossmc.mosscg.MoBoxPoint.Main;
import org.mossmc.mosscg.MoBoxPoint.Mysql.MysqlGetData;
import org.mossmc.mosscg.MoBoxPoint.Mysql.MysqlUpdateData;

import java.util.UUID;

public class UserUpdate {
    public static void userAddScore(String name,String key,int score) {
        JSONObject jsonObject = MysqlGetData.getResult(name);
        if (jsonObject == null) {
            Main.logger.warning("积分操作失败！参数："+name+" | "+key+" | "+score);
            return;
        }
        DataUpdate.addScore(jsonObject,key,score);
        MysqlUpdateData.updateData(jsonObject,name);
    }

    public static void userAddScore(UUID uuid, String key, int score) {
        OfflinePlayer player = Bukkit.getOfflinePlayer(uuid);
        JSONObject jsonObject = MysqlGetData.getResult(player.getName());
        if (jsonObject == null) {
            Main.logger.warning("积分操作失败！参数："+player.getName()+" | "+key+" | "+score);
            return;
        }
        DataUpdate.addScore(jsonObject,key,score);
        MysqlUpdateData.updateData(jsonObject,player.getName());
    }
}
