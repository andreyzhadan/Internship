package com.zhadan.sql.junior.dao;

import com.zhadan.sql.junior.bean.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by azhadan on 7/29/13.
 */
public interface UserDao {
    public void insert(User user) throws SQLException;

    public List<User> selectAll() throws SQLException;
}
