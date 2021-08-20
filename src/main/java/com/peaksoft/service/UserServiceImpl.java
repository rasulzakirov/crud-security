package com.peaksoft.service;

import com.peaksoft.dao.UserDao;
import com.peaksoft.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);

    }
    
    @Override
    public void updateUser(User user, int id) {
        userDao.updateUser(user, id);
    }


    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Override
    public User get(int id) {
        return userDao.get(id);
    }
    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

}
