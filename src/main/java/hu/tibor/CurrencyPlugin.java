package hu.tibor;

import hu.tibor.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class CurrencyPlugin extends JavaPlugin {
    private Utils utils;

    @Override
    public void onEnable() {
        //
                          //Startup message
        Bukkit.getLogger().info(this.getName()+"§a Ready to use!");

        //
        utils = new Utils(this);
    }
    @Override
    public void onDisable() {

    }
}
