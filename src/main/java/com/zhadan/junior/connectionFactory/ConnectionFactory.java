package com.zhadan.junior.connectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by azhadan on 7/29/13.
 */
public interface ConnectionFactory {
    public Connection newConnection() throws SQLException;

    public void close() throws SQLException;
}
