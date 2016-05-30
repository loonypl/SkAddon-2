package amao.krzysek.skaddon.effects.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL {

    private Connection connection;
    private Statement statement;

    public MySQL() {}

    public void openConnection(String host, String port, String database, String user, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?autoReconnect=true&user=" + user + "&password=" + password);
            statement = connection.createStatement();
        } catch (SQLException ex1) {
            ex1.printStackTrace();
        } catch (ClassNotFoundException ex2) {
            ex2.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            if(!(connection.isClosed()))
                connection.close();
            if(!(statement.isClosed()))
                statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void query(String query) {
        try {
            statement.executeQuery(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void update(String update) {
        try {
            statement.executeUpdate(update);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
