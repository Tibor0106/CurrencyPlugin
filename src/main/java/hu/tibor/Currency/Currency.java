package hu.tibor.Currency;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Currency implements ICurrency{
    private Plugin plugin;
    public Currency(Plugin plugin){
        this.plugin = plugin;
    }

    @Override
    public void DepositPlayer(Player player, double amount) {

    }

    @Override
    public void WithdrawPlayer(Player player, double amount) {

    }

    @Override
    public void DepositPlayer(String playerName, double amount) {

    }

    @Override
    public void WithdrawPlayer(String playerName, double amount) {

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
