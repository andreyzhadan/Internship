package com.zhadan;

import com.zhadan.junior.bean.User;
import com.zhadan.junior.controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 07.07.13
 * Time: 18:51
 */
public class SpringTest {
    private UserController userController;

    @Before
    public void setUp() throws Exception {
        ApplicationContext appCtx
                = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        this.userController = appCtx.getBean("userController", UserController.class);
    }

    @Test
    public void test() throws Exception {
        userController.register("John", "Papa", 47);
        List<User> users = userController.showAll();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
