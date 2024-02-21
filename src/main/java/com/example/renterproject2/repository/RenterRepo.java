package com.example.renterproject2.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RenterRepo {
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "12345";

    public Connection connectToDataBase() {

        Connection connection = null;
        {
            try {
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                System.out.println("Ошибка при соединение56789 ! "+e.getMessage());
            }
        }
        return connection;
    }
}