package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class DbConnection {
    private static Connection connection = null;

    private static String url = "jdbc:mysql://127.0.0.1:3306/abc";
    private static String uname = "root";
    private static String pass = "pushkar2196";

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, uname, pass);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
