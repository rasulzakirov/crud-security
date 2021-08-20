package com.peaksoft.dao;

import com.peaksoft.user.User;

import java.util.List;

public interface UserDao {
 List<User> getAllUser();

 void  addUser(User user );

 void updateUser(User user, int id);

 void deleteUser(int id);

 User get(int id);
 User findByUsername(String username);
}
