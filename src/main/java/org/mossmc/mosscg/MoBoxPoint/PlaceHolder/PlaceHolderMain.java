package org.mossmc.mosscg.MoBoxPoint.PlaceHolder;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.mossmc.mosscg.MoBoxPoint.User.UserGet;

public class PlaceHolderMain extends PlaceholderExpansion {
    @Override
    public String getAuthor() {
        return "MossCG";
    }

    @Override
    public String getIdentifier() {
        return "moboxpoint";
    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }

    @Override
    public String onPlaceholderRequest(Player player, String identifier) {
        return String.valueOf(UserGet.getUserScore(player.getName(),identifier));
    }
}
