package com.peaksoft.dao;


import com.peaksoft.user.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public class UserDaoImpl implements  UserDao {
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<User> getAllUser() {
        return sessionFactory.openSession().createQuery("from  User ").getResultList();

    }

    @Override
    public void addUser(User user) {
        sessionFactory.openSession().save(user);

    }

    @Override
    public void deleteUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(User.class, id));
    }

    @Override
    public User get(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);

    }


    @Override
    public void updateUser(User user, int id) {
        Session session = sessionFactory.getCurrentSession();
        User user1 = session.get(User.class, id);
        user1.setAge(user.getAge());
        user1.setName(user.getName());

    }


    @Override
    public User findByUsername(String username) {
        List<User> users = getAllUser();
        return users.stream().filter(x -> x.getUsername().equals(username)).findAny().orElse(new User());
    }

}