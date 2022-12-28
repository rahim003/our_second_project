package org.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConfig {
    public final Connection connection;

    public JDBCConfig() throws SQLException {
        this.connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/java8",
                "postgres",
                "123123");
    }

    public Connection getConnection() {
        return connection;
    }
}
