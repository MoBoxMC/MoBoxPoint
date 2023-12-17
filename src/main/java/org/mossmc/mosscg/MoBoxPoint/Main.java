package org.mossmc.mosscg.MoBoxPoint;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.mossmc.mosscg.MoBoxCore.Info.InfoGroupBackend;
import org.mossmc.mosscg.MoBoxPoint.Cache.CacheListener;
import org.mossmc.mosscg.MoBoxPoint.Command.CommandAdd;
import org.mossmc.mosscg.MoBoxPoint.Command.CommandGet;
import org.mossmc.mosscg.MoBoxPoint.Mysql.MysqlTable;
import org.mossmc.mosscg.MoBoxPoint.PlaceHolder.PlaceHolderMain;

import java.util.logging.Logger;

public class Main extends JavaPlugin {
    public static Configuration getConfig;
    public static Logger logger;

    @Override
    public void onLoad() {
        saveDefaultConfig();
        getConfig().options().copyDefaults(true);
        logger = getLogger();
        getConfig = getConfig();
        BasicInfo.instance = this;
    }

    @Override
    public void onEnable() {
        InfoGroupBackend.sendPluginStartGroup(BasicInfo.pluginName, BasicInfo.pluginVersion);
        logger.info("正在注册缓存事件监听器");
        Bukkit.getPluginManager().registerEvents(new CacheListener(),this);
        logger.info("缓存事件监听器注册完成");
        Plugin pluginPlaceholderAPI = Bukkit.getPluginManager().getPlugin("PlaceholderAPI");
        if (pluginPlaceholderAPI != null){
            logger.info("检测到PlaceHolderAPI插件，变量功能已启用！");
            new PlaceHolderMain().register();
        }
        logger.info("正在初始化数据库");
        MysqlTable.checkTable();
        logger.info("数据库初始化完成");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 1) {
            return false;
        }
        switch (args[0]) {
            case "get":
                CommandGet.execute(sender,args);
                break;
            case "add":
                CommandAdd.execute(sender,args);
                break;
            default:
                sender.sendMessage("未知指令！");
        }
        return true;
    }
}
