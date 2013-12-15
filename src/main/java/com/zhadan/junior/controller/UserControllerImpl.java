package com.zhadan.junior.controller;

import com.zhadan.junior.bean.User;
import com.zhadan.junior.dao.UserDao;
import com.zhadan.junior.validator.UserValidator;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 07.07.13
 * Time: 19:15
 */
public class UserControllerImpl implements UserController {

    private UserDao dao;
    private UserValidator validator;

    public void setValidator(UserValidator validator) {
        this.validator = validator;
    }

    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public void register(String name, String surname, int age) throws SQLException {
        User user = new User(name, surname, age);
        Map<String, String> errorMap = validator.validate(user);
        if (errorMap.isEmpty()) {
            dao.insert(user);
            System.out.println("redirect to OK.jsp");
        } else {
            System.out.println(errorMap);
            System.out.println("redirect to ERROR.jsp");
        }
    }

    @Override
    public List<User> showAll() throws SQLException {
        return dao.selectAll();
    }
}
