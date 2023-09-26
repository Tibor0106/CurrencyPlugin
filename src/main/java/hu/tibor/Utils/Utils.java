package hu.tibor.Utils;

import org.bukkit.plugin.Plugin;

public class Utils {



    //Class's constructor
    public Utils(Plugin pl){
        this.plugin = pl;
    }
    private  Plugin plugin;
    public String CHAT_PREFIX;

    private  void getPrefix(){
        this.CHAT_PREFIX = plugin.getConfig().getString("ChatPrefix").replace("&", "§");
    }
}
