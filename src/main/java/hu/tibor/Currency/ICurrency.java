package hu.tibor.Currency;

import hu.tibor.MySql.Database;
import org.bukkit.entity.Player;

import java.sql.Connection;
import java.util.UUID;

public interface ICurrency {
    boolean DepositPlayer(Player player, double amount);
    boolean WithdrawPlayer(Player player, double amount);
    boolean DepositPlayer(String playerName, double amount);
    boolean WithdrawPlayer(String playerName, double amount);
    double getBalance(Player pplayer);
    double getBalance(String playerName);
    boolean playerExits(UUID uuid);
    boolean playerExits(String uuid);
    boolean playerExits(Player player);
    Connection getConnetion();

    boolean registerPlayer(Player player);
}
