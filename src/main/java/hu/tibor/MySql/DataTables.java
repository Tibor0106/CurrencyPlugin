package hu.tibor.MySql;

import hu.tibor.CurrencyPlugin;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DataTables {
    private Connection connection;
    private Statement statement;
    private  MySql mySql;
    public DataTables(){
        mySql = CurrencyPlugin.getMysqlDataHandler();
        connection = mySql.getConnetion();
        userTable();
    }
    public void userTable(){
        try {
            statement = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS currency (`playerUUID`, ´currency´);";
            statement.execute(sql);
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
