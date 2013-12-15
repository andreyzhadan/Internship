package com.zhadan.junior.hibernate;


import com.zhadan.junior.bean.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 07.07.13
 * Time: 12:54
 */
public class HibernateEntryPoint {
    public static void main(String[] args) {

        // Read
        System.out.println("******* READ *******");
        List users = HibernateUserManager.list();
        System.out.println("Total Users: " + users.size());


        // Write
        System.out.println("******* WRITE *******");
        User user = new User("Jack", "Bauer", 21);
        user = HibernateUserManager.save(user);
        user = HibernateUserManager.read(user.getId());
        System.out.printf("%d %s %s \n", user.getId(), user.getName(), user.getSurname());


        // Update
        System.out.println("******* UPDATE *******");
        User user2 = HibernateUserManager.read(1l); // read user with id 1
        System.out.println("Name Before Update:" + user2.getName());
        user2.setName("James");
        HibernateUserManager.update(user2);  // save the updated user details

        user2 = HibernateUserManager.read(1l); // read again user with id 1
        System.out.println("Name After Update:" + user2.getName());


        // Delete
        System.out.println("******* DELETE *******");
        HibernateUserManager.delete(user);
        User user3 = HibernateUserManager.read(user.getId());
        System.out.println("Object:" + user3);
    }
}
