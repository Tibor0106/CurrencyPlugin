package hu.tibor.Currency;

import org.bukkit.entity.Player;

public interface ICurrency {
    void DepositPlayer(Player player, double amount);
    void WithdrawPlayer(Player player, double amount);
    void DepositPlayer(String playerName, double amount);
    void WithdrawPlayer(String playerName, double amount);
    double getBalance(Player pplayer);
    double getBalance(String playerName);
}
