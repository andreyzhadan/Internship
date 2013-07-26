package sql;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


/**
 * Created by azhadan on 7/25/13.
 */
public class ConnectionPool {
    private static final String url = "jdbc:mysql://localhost:3306/study";
    private static final Logger LOGGER = Logger.getLogger(ConnectionPool.class.getName());
    private static BlockingQueue<PooledConnection> poolableConnections;//non list

    public ConnectionPool(int size) {
        this.poolableConnections = new LinkedBlockingQueue<PooledConnection>();
        for (int i = 0; i < size; i++) {
            try {
                createNewConnection();
            } catch (SQLException ex) {
                LOGGER.error("Cannot open connection");
            }
        }
    }

    public synchronized PooledConnection getConnectionFromPool() throws SQLException {
        if (!poolableConnections.isEmpty()) {
            return poolableConnections.remove();
        } else {
            return createNewConnection();
        }
    }

    public synchronized void returnConnectionToPool(PooledConnection connection) {
        this.poolableConnections.add(connection);
    }

    private PooledConnection createNewConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(url, "root", "sadmin");
        PooledConnection poolableConnection = new PooledConnection(this, connection);
        poolableConnections.add(poolableConnection);
        return poolableConnection;
    }
}
