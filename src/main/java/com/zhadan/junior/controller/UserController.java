package com.zhadan.junior.controller;


import com.zhadan.junior.bean.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 07.07.13
 * Time: 19:13
 */
public interface UserController {
    public void register(String name, String surname, int age) throws SQLException;

    public List<User> showAll() throws SQLException;
}
