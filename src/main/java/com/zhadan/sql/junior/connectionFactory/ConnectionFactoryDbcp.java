package com.zhadan.sql.junior.connectionFactory;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by azhadan on 7/29/13.
 */
public class ConnectionFactoryDbcp implements ConnectionFactory {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/study";
    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private final BasicDataSource dataSource;

    public ConnectionFactoryDbcp() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(DRIVER_CLASS);
        ds.setUsername("root");
        ds.setPassword("sadmin");
        ds.setUrl(JDBC_URL);
        dataSource = ds;
    }

    public Connection newConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public void close() throws SQLException {
        dataSource.close();
    }
}
