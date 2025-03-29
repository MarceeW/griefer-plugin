package com.marcew.grieferplugin;

import com.marcew.grieferplugin.events.PlayerHitListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class GrieferPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerHitListener(), this);

    }
}
