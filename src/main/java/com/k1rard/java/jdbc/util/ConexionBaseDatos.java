package com.k1rard.java.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {

    private static final String URL = "jdbc:mysql://localhost:3306/java_curso?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "Admin";
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if(connection == null){
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }

        return connection;
    }

}
