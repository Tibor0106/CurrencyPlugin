package hu.tibor.MySql;

import org.bukkit.plugin.Plugin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public String host;
    public int port;
    public String database;
    public String username;
    public String password;
    private Connection connection;

    public Database(Plugin pl) {
        this.host = pl.getConfig().getString("host");
        this.port = pl.getConfig().getInt("port");
        this.database = pl.getConfig().getString("database");
        this.username = pl.getConfig().getString("username");
        this.password = pl.getConfig().getString("password");
    }

    public boolean Connect() {
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

    public Connection getConnection() {
        return connection;
    }
}
