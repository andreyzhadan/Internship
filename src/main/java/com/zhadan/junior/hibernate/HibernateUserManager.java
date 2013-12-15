package com.zhadan.junior.hibernate;

import com.zhadan.junior.bean.User;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 07.07.13
 * Time: 12:55
 */
@SuppressWarnings("JpaQlInspection")
public class HibernateUserManager {
    public static User save(User user) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();

        Long id = (Long) session.save(user);
        user.setId(id);

        session.getTransaction().commit();

        session.close();

        return user;
    }

    public static List list() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        List users = session.createQuery("from User").list();
        session.close();
        return users;
    }

    public static User read(Long id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        User user = (User) session.get(User.class, id);
        session.close();
        return user;
    }

    public static User update(User user) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        session.merge(user);

        session.getTransaction().commit();

        session.close();
        return user;

    }

    public static void delete(User user) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        session.delete(user);

        session.getTransaction().commit();

        session.close();
    }
}
