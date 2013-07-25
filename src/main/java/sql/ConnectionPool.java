package sql;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Queue;


/**
 * Created by azhadan on 7/25/13.
 */
public class ConnectionPool {
    private static final String url = "jdbc:mysql://localhost:3306/study";
    private static final Logger LOGGER = Logger.getLogger(ConnectionPool.class.getName());
    private Queue<PoolableConnection> poolableConnections;//non list

    public ConnectionPool() {
        this.poolableConnections = new LinkedList<PoolableConnection>();
        PoolableConnection poolableConnection = new PoolableConnection();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, "root", "sadmin");
            poolableConnection.setConnection(connection);
            for (int i = 0; i < 5; i++) {
                this.poolableConnections.add(poolableConnection);
            }
        } catch (SQLException e) {
            LOGGER.error("Cannot open connection");//log4j
        }
    }

    public synchronized PoolableConnection getConnection() {
        return !poolableConnections.isEmpty() ? poolableConnections.remove() : null; //CollectionUtils  apache
    }

    public synchronized void putConnection(PoolableConnection connection) {
        this.poolableConnections.add(connection);
    }
}
