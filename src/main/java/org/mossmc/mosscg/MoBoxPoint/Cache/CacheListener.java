package org.mossmc.mosscg.MoBoxPoint.Cache;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.mossmc.mosscg.MoBoxPoint.Mysql.MysqlGetData;

public class CacheListener implements Listener {
    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent event) {
        String name = event.getPlayer().getName();
        CacheUser.inputCache(name,MysqlGetData.getResult(name));
        //Main.logger.info("玩家登入，已将数据加入缓存！");
    }

    @EventHandler
    public static void onPlayerExit(PlayerQuitEvent event) {
        CacheUser.removeCache(event.getPlayer().getName());
        //Main.logger.info("玩家退出，已将数据移出缓存！");
    }
}
