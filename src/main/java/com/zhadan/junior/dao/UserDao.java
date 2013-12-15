package com.zhadan.junior.dao;

import com.zhadan.junior.bean.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 07.07.13
 * Time: 18:55
 */
public interface UserDao {
    public void insert(User user) throws SQLException;

    public List<User> selectAll() throws SQLException;
}
