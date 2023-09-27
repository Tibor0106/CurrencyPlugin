package hu.tibor;

import hu.tibor.Commands.CCurrency_player;
import hu.tibor.MySql.MySql;
import hu.tibor.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class CurrencyPlugin extends JavaPlugin {
    private Utils utils;
    public MySql mySql;


    @Override
    public void onEnable() {
        //
                          //Startup message
        Bukkit.getLogger().info(this.getName()+"§a Ready to use!");


        //
        utils = new Utils(this);
        mySql = new MySql(this, true);
        //commands
        getServer().getPluginCommand("currency-player").setExecutor(new CCurrency_player());
    }
    @Override
    public void onDisable() {
    }
    public MySql getMysqlDataHandler(){
        return mySql;
    }

}
