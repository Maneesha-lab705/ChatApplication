package lk.ijse.catmoon.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private final static String URL = "jdbc:mysql://localhost:3306/chat";
    private final static Properties props = new Properties();

    static {
        props.setProperty("user","root");
        props.setProperty("password","1234");

    }
    private static DBConnection dbConnection;
    private Connection connection;


 private DBConnection() throws SQLException {
     connection =DriverManager.getConnection(URL,props);
 }

   public  static DBConnection getInstance() throws SQLException {
        if (dbConnection == null){
            return dbConnection =new DBConnection();
        }
        return dbConnection;
   }
    public Connection getConnection() {
        return connection;
    }
}


