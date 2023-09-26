package hu.tibor.Currency;

import org.bukkit.entity.Player;

public interface ICurrency {
    boolean DepositPlayer(Player player, double amount);
    boolean WithdrawPlayer(Player player, double amount);
    boolean DepositPlayer(String playerName, double amount);
    boolean WithdrawPlayer(String playerName, double amount);
    double getBalance(Player pplayer);
    double getBalance(String playerName);
}
