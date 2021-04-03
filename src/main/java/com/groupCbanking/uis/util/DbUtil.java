package com.groupCbanking.uis.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbUtil {

    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/user_db";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "root123";

    public static Connection getConnection() throws SQLException{
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
    }
}
