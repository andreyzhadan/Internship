package com.zhadan.junior.dao;

import com.zhadan.junior.ConnectionFactoryFactory;
import com.zhadan.junior.bean.User;
import com.zhadan.junior.connectionFactory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 07.07.13
 * Time: 18:56
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
