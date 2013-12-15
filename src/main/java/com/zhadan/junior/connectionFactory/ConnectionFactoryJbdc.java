package com.zhadan.junior.connectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by azhadan on 7/29/13.
 */
public class ConnectionFactoryJbdc implements ConnectionFactory {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/study";

    public Connection newConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, "root", "sadmin");
    }

    public void close() throws SQLException {
        //nothing to closeAllConnections
    }
}
