package com.zhadan.junior;

import com.zhadan.junior.connectionFactory.ConnectionFactory;
import com.zhadan.junior.connectionFactory.ConnectionFactoryDbcp;
import com.zhadan.junior.connectionFactory.ConnectionFactoryJbdc;

/**
 * Created by azhadan on 7/29/13.
 */
public class ConnectionFactoryFactory {
    private static FactoryType currentType = FactoryType.RAW;
    //    private static List<ConnectionFactory> allFactories = new LinkedList<ConnectionFactory>();

    //    public static synchronized void setType(FactoryType type) {
    //        currentType = type;
    //    }

    public synchronized static ConnectionFactory newConnectionFactory() {
        ConnectionFactory result = null;
        switch (currentType) {
            case RAW:
                result = new ConnectionFactoryJbdc();
                break;
            case DBCP:
                result = new ConnectionFactoryDbcp();
                break;
            default:
                throw new RuntimeException("This is never happens");
        }
        return result;
    }

    public static enum FactoryType {RAW, DBCP}
}
