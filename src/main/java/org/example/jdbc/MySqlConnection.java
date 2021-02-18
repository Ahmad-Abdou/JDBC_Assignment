package org.example.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {

    public static Connection connect() {
        Connection connection = null;
        try {
             connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "1234");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
