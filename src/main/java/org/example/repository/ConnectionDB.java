package org.example.repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String urlConnection = "jdbc:mysql://localhost/blockbuster?"
                            + "user=root&password=admin";
    
    public Connection createConnection() throws SQLException{
        Connection con = DriverManager.getConnection(urlConnection);
        return con;
    }
    
    public void closeConnection(Connection con) throws SQLException{
        con.close();
    }
}
