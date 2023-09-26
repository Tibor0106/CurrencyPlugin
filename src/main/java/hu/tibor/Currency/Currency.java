package hu.tibor.Currency;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Currency implements ICurrency{
    private Plugin plugin;
    public Currency(Plugin plugin){
        this.plugin = plugin;
    }


    @Override
    public boolean DepositPlayer(Player player, double amount) {
        return false;
    }

    @Override
    public boolean WithdrawPlayer(Player player, double amount) {
        return false;
    }

    @Override
    public boolean DepositPlayer(String playerName, double amount) {
        return false;
    }

    @Override
    public boolean WithdrawPlayer(String playerName, double amount) {
        return false;
    }

    @Override
    public double getBalance(Player pplayer) {
        return 0;
    }

    @Override
    public double getBalance(String playerName) {
        return 0;
    }
}
