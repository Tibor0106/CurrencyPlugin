package hu.tibor.MySql;

import hu.tibor.Currency.ICurrency;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

public class MySql implements ICurrency{
    private boolean isEnabled;
    private Statement statement;
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
            try{
                this.statement = connection.createStatement();
            }catch (SQLException err){
                err.printStackTrace();
                return;
            }
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
        try{
            statement = connection.createStatement();
            String sql = "SELECT * FROM currency WHERE playerName LIKE "+player.getName()+";";
            int count = statement.executeUpdate(sql);
            if(count > 0){
                return true;
            }
        }catch (SQLException err){
            err.printStackTrace();;
        }
        return false;
    }

    @Override
    public Connection getConnetion() {
        return connection;
    }

    @Override
    public boolean registerPlayer(Player player) {
        if(this.playerExits(player)){
            return false;
        }
        try{
            statement = connection.createStatement();
            String sql = "INSERT INTO currency (`playerUUID`, `playerName`, `currency`) VALUES ('"+player.getUniqueId().toString()+"', '"+player.getName()+"', 0)";
            return statement.execute(sql);

        }catch (SQLException err){
            err.printStackTrace();
        }
        return false;
    }


}
