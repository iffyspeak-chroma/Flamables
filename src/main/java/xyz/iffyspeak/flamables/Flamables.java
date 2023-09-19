package xyz.iffyspeak.flamables;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.iffyspeak.flamables.Tools.Globals;

public final class Flamables extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Globals.Item.initAllItems();
        getServer().getPluginManager().registerEvents(new EventListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
