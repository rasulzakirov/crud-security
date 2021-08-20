package com.peaksoft.service;

import com.peaksoft.user.User;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public interface UserService {
    List<User> getAllUser();

    void addUser(User user);

    void updateUser(User user, int id);

    User get(int id);

    void deleteUser(int id);
    User findByUsername(String username);

}
