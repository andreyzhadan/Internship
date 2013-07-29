package com.zhadan.sql.junior.dao;

import com.zhadan.sql.junior.ConnectionFactoryFactory;
import com.zhadan.sql.junior.bean.User;
import com.zhadan.sql.junior.connectionFactory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by azhadan on 7/29/13.
 */
public class UserDaoJdbc implements UserDao {
    private static final String INSERT_SQL = "INSERT into user values (default,?,?,?) ";
    private static final String SELECT_SQL = "SELECT * from study.user";
    private final ConnectionFactory connectionFactory = ConnectionFactoryFactory.newConnectionFactory();

    public void insert(User user) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement ps = null;
        conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        conn.setAutoCommit(false);
        ps = conn.prepareStatement(INSERT_SQL);
        ps.setString(1, user.getName());
        ps.setString(2, user.getSurname());
        ps.setInt(3, user.getAge());
        ps.executeUpdate();
        conn.commit();
    }

    private Connection getConnection() throws SQLException {
        return connectionFactory.newConnection();
    }

    public List<User> selectAll() throws SQLException {
        List<User> users = new ArrayList<User>();
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(SELECT_SQL);
        while (rs.next()) {
            User user = new User();
            user.setName(rs.getString("Name"));
            user.setSurname(rs.getString("Surname"));
            users.add(user);
        }
        return users;
    }
}
