package com.example.student01.memoryManagment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class DatabaseManager {

    @Autowired
    private DataSource dataSource;

    // Get connection
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    // Close connection
    public void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

