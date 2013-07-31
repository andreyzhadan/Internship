package com.zhadan;

import com.zhadan.bean.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by azhadan on 7/31/13.
 */
public class UserCheckFilter implements Filter {
    public void init(FilterConfig fConfig) throws ServletException {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession httpSession = req.getSession();
        User userFromSession = (User) httpSession.getAttribute("user");
        if (userFromSession == null && req.getMethod() != "POST") {
            req.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
        chain.doFilter(request, response);
    }
}
