package hu.tibor.MySql;

import hu.tibor.Currency.ICurrency;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.sql.*;
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
        if(!playerExits(playerName)){
            return false;
        }
        try{
            statement = connection.createStatement();
            String sql = "UPDATE currency SEt currency = "+amount+" WHERE playerName like '"+playerName+"'";
            if(statement.executeUpdate(sql) == 1){
                return true;
            }
        }catch (SQLException err){
            err.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean WithdrawPlayer(String playerName, double amount) {
        return false;
    }

    @Override
    public double getBalance(Player player) {
        return this.getBalance(player.getName());
    }

    @Override
    public double getBalance(String playerName) {
        try{
            statement = connection.createStatement();
            String sql = "SELECT * FROM currency WHERE playerName like '"+playerName+"'";
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                return resultSet.getDouble("currency");
            }
        }catch (SQLException err){
            err.printStackTrace();;
        }
        return -1;
    }

    @Override
    public boolean playerExits(UUID uuid) {
        return false;
    }

    @Override
    public boolean playerExits(String playerName) {
        try{
            statement = connection.createStatement();
            String sql = "SELECT * FROM currency WHERE playerName LIKE '"+playerName+"';";
            ResultSet resultSet =  statement.executeQuery(sql);
            int rowCount = 0;
            while (resultSet.next()) {
                rowCount++;
            }
            if(rowCount == 1){
                return true;
            }
        }catch (SQLException err){
            err.printStackTrace();;
        }
        return false;
    }

    @Override
    public boolean playerExits(Player player) {
       return  this.playerExits(player.getName());
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
