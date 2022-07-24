package org.mossmc.mosscg.MoBoxPoint.Command;

import org.bukkit.command.CommandSender;
import org.mossmc.mosscg.MoBoxPoint.Data.DataUpdate;
import org.mossmc.mosscg.MoBoxPoint.User.UserUpdate;

public class CommandAdd {
    //指令形式：/moboxpoint add MossCG main 20
    public static void execute(CommandSender sender, String[] args) {
        if (!sender.hasPermission("moboxpoint.add") && !sender.isOp()) {
            sender.sendMessage("您没有权限！");
            return;
        }
        if (args.length < 4) {
            sender.sendMessage("指令使用：/moboxpoint add <玩家> <类型> <数量>");
            return;
        }
        try {
            int addNumber = Integer.parseInt(args[3]);
            UserUpdate.userAddScore(args[1],args[2],addNumber);
            sender.sendMessage("操作成功！");
        } catch (Exception e) {
            e.printStackTrace();
            sender.sendMessage("指令使用：/moboxpoint add <玩家> <类型> <数量>");
        }
    }
}
