package sql;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Created by azhadan on 7/23/13.
 */
public class SqlClient {

    private static final Logger LOGGER = Logger.getLogger(SqlClient.class.getName());

    public static void main(String[] args) {
        final ConnectionPool connectionPool = new ConnectionPool();
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            service.submit(new Runnable() {
                public void run() {
                    Random random = new Random();
                    int waitTime = random.nextInt(3000);
                    try {
                        Thread.currentThread().sleep(waitTime);
                        makeSqlCall(connectionPool);
                    } catch (InterruptedException e) {
                        LOGGER.error("Interrupted exception");
                    }
                }
            });
        }
    }

    public static void makeSqlCall(ConnectionPool connectionPool) {
        ConnectionWrapper poolableConnection = connectionPool.getConnection();
        Connection conn = poolableConnection.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from person");
            LOGGER.info("--------New Connection--------");
            while (rs.next()) {
                LOGGER.info(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
            } catch (SQLException e) {
                LOGGER.error("Cannot close RS && STMT");
            }
            poolableConnection.close(connectionPool);
        }
    }

    //PropertyConfigurator.configure("log4j.properties");

    //  DatabaseMetaData metaData = conn.getMetaData();
    //  System.out.println(metaData.getDatabaseProductName());
    //  System.out.println(conn.getAutoCommit());


    //  PreparedStatement preparedStatement = conn.prepareStatement("select * from person where id=?");
    //  preparedStatement.setLong(1, 1L);
}
