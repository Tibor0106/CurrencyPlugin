package hu.tibor.MySql;

import hu.tibor.Currency.ICurrency;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.UUID;

public class MySql implements ICurrency{
    private boolean isEnabled;
    private Connection connection;
    private Database database;
    private Plugin plugin;
    public MySql(Plugin plugin, boolean enable){
        this.plugin = plugin;
        this.isEnabled = enable;
        if(!enable){
            return;
        }
        Database database = new Database(plugin);
        if(database.Connect()){
            Bukkit.getLogger().info(plugin.getName()+" §aDatabase connected!");
            connection = database.getConnection();
        } else {
            Bukkit.getLogger().severe(plugin.getName()+" §cError while connecting database!");
        }

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

    @Override
    public boolean playerExits(UUID uuid) {
        return false;
    }

    @Override
    public boolean playerExits(String uuid) {
        return false;
    }

    @Override
    public boolean playerExits(Player player) {
        return false;
    }

    @Override
    public Connection getConnetion() {
        return connection;
    }


}
