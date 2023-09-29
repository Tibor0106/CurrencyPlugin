package hu.tibor.Listeners;

import hu.tibor.CurrencyPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

import java.util.Currency;

public class PlayerJoin implements Listener {
    public PlayerJoin(Plugin plugin){
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void OnJoin (PlayerJoinEvent e){
        CurrencyPlugin.getMysqlDataHandler().registerPlayer(e.getPlayer());
    }
}
