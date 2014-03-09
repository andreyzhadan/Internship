package com.zhadan;

import com.zhadan.junior.bean.User;
import com.zhadan.junior.hibernate.HibernateUtil;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 07.07.13
 * Time: 16:56
 */
public class HibernateCacheLevel {

    @Test
    public void testUse() throws Exception {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        User user = (User) session.get(User.class, 1L);
        long t0 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            user = (User) session.get(User.class, 1L);
        }
        System.out.println(System.currentTimeMillis() - t0);
        tx.commit();
        session.close();
    }

    @Test
    public void testNotUse() throws Exception {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        long t0 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            Transaction tx = session.beginTransaction();
            User user = (User) session.get(User.class, 1L);
            tx.commit();
        }
        System.out.println(System.currentTimeMillis() - t0);
        session.close();
    }
}
