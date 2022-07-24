package org.mossmc.mosscg.MoBoxPoint.Command;

import com.alibaba.fastjson.JSONObject;
import org.bukkit.command.CommandSender;
import org.mossmc.mosscg.MoBoxPoint.User.UserGet;

import java.util.Map;

public class CommandGet {
    //指令形式：/moboxpoint get MossCG
    public static void execute(CommandSender sender, String[] args) {
        if (!sender.hasPermission("moboxpoint.get") && !sender.isOp()) {
            sender.sendMessage("您没有权限！");
            return;
        }
        if (args.length < 2) {
            sender.sendMessage("指令使用：/moboxpoint get <玩家>");
            return;
        }
        try {
            JSONObject jsonObject = UserGet.getUserData(args[1]);
            sender.sendMessage("玩家"+args[1]+"的积分数据");
            for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
                sender.sendMessage("|-" + entry.getKey() + "积分：" + entry.getValue().toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            sender.sendMessage("指令使用：/moboxpoint get <玩家>");
        }
    }
}
