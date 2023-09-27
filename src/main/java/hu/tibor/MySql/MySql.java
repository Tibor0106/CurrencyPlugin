package hu.tibor.MySql;

import hu.tibor.Currency.ICurrency;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySql implements ICurrency{
    private boolean isEnabled;
    private Connection connection;
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

}
class Database {
    public String host;
    public int port;
    public String database;
    public String username;
    public String password;
    public static Connection connection;

    public Database(Plugin pl){
        this.host = pl.getConfig().getString("host");
        this.port =  pl.getConfig().getInt("port");
        this.database =  pl.getConfig().getString("database");
        this.username =  pl.getConfig().getString("username");
        this.password =  pl.getConfig().getString("password");
    }
    public boolean Connect(){
        String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
