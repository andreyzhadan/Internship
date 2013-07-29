package com.zhadan.sql.pool;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Created by azhadan on 7/23/13.
 */
public class SqlClient {

    private static final Logger LOGGER = Logger.getLogger(SqlClient.class.getName());
    private static ConnectionPool connectionPool;

    public static void getMetaData() {
        ResultSet rs = null;
        Connection connection = null;
        try {
            connection = connectionPool.getConnectionFromPool();
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            String catalog = null;
            String schemaPattern = null;
            String tableNamePattern = null;
            String[] types = null;
            LOGGER.info("Table names");
            rs = databaseMetaData.getTables(catalog, schemaPattern, tableNamePattern, types);
            while (rs.next()) {
                String columnName = rs.getString(3);
                LOGGER.info(columnName);
            }

            LOGGER.info("Column names on person table");
            tableNamePattern = "person";
            String columnNamePattern = null;
            rs = databaseMetaData.getColumns(
                    catalog, schemaPattern, tableNamePattern, columnNamePattern);

            while (rs.next()) {
                String columnName = rs.getString(4);
                int columnType = rs.getInt(5);
                LOGGER.info(columnName + " / " + columnType);
            }
        } catch (SQLException e) {
            LOGGER.error("Smth bad happens");
        } finally {
            try {
                rs.close();
                connection.close();
            } catch (SQLException e) {
                LOGGER.error("Cannot closeAllConnections RS && STMT");
            }
        }
    }

    public static void makeSqlCall() {
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            connection = connectionPool.getConnectionFromPool();
            stmt = connection.createStatement();
            rs = stmt.executeQuery("select * from person");
            LOGGER.info("--------New Connection--------");
            while (rs.next()) {
                LOGGER.info(rs.getString("name"));
            }
        } catch (SQLException e) {
            LOGGER.error("Smth bad happens");
        } finally {
            try {
                rs.close();
                stmt.close();
                connection.close();
            } catch (SQLException e) {
                LOGGER.error("Cannot closeAllConnections RS && STMT");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException, SQLException {
        connectionPool = new ConnectionPool(5);
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            service.submit(new Runnable() {
                public void run() {
                    Random random = new Random();
                    int waitTime = random.nextInt(3000);
                    try {
                        Thread.currentThread().sleep(waitTime);
                        makeSqlCall();
                    } catch (InterruptedException e) {
                        LOGGER.error("Interrupted exception");
                    }
                }
            });
        }
        getMetaData();
        connectionPool.closeAllConnections();
    }


    //PropertyConfigurator.configure("log4j.properties");

    //  DatabaseMetaData metaData = conn.getMetaData();
    //  System.out.println(metaData.getDatabaseProductName());
    //  System.out.println(conn.getAutoCommit());


    //  PreparedStatement preparedStatement = conn.prepareStatement("select * from person where id=?");
    //  preparedStatement.setLong(1, 1L);
}
