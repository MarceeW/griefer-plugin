package com.marcew.grieferplugin;

import com.marcew.grieferplugin.events.BoomBowListener;
import com.marcew.grieferplugin.events.PlayerHitListener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginManager;

public final class GrieferPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new PlayerHitListener(), this);
        pm.registerEvents(new BoomBowListener(), this);
    }
}
