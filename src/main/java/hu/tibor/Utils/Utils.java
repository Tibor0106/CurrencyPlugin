package hu.tibor.Utils;

import org.bukkit.plugin.Plugin;

public class Utils {



    //Class's constructor
    public Utils(Plugin pl){
        this.plugin = pl;
        getPrefix();
        getCurrencyName();
    }
    private  Plugin plugin;
    public static String CHAT_PREFIX;
    public static String CurrencyName;

    private void getPrefix(){
        this.CHAT_PREFIX = plugin.getConfig().getString("ChatPrefix").replace("&", "§");
    }
    private void getCurrencyName(){
        this.CurrencyName  = plugin.getConfig().getString("CurrencyName");
    }
}
