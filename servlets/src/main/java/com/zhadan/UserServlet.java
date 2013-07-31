package com.zhadan;

import com.zhadan.bean.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by azhadan on 7/30/13.
 */
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = -6500557339421743748L;
    private static final ConcurrentMap<String, User> users = getUsers();

    private static ConcurrentMap<String, User> getUsers() {
        ConcurrentMap<String, User> users = new ConcurrentHashMap<String, User>();
        User user1 = new User("andrey", "admin");
        User user2 = new User("igor", "admin");
        users.put(user1.getLogin(), user1);
        users.put(user2.getLogin(), user2);
        return users;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jkinopoisk/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd;
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = validateUser(login, password);
        if (user == null) {
            rd = req.getRequestDispatcher("login.jsp");
        } else {
            req.getSession().setAttribute("user", user);
            rd = req.getRequestDispatcher("jkinopoisk/index.jsp");
        }
        rd.forward(req, resp);
    }

    private User validateUser(String login, String password) {
        if (login == null || password == null) {
            return null;
        }
        User user = users.get(login);
        if (user == null) {
            return null;
        }
        if (!user.getPassword().equals(password.trim())) {
            return null;
        }
        return user;
    }
}
