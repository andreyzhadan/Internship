package sql;

import java.sql.Connection;

/**
 * Created by azhadan on 7/25/13.
 */
public class PoolableConnection {
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void close(ConnectionPool connectionPool) {
        connectionPool.putConnection(this);
    }
}
