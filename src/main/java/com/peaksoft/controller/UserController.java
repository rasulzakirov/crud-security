

package com.peaksoft.controller;

import com.peaksoft.service.RoleService;
import com.peaksoft.service.UserService;
import com.peaksoft.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")

public class UserController {
    @Autowired
    private final UserService userService;
    @Autowired
    private final RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }




    @GetMapping("/user")

    public  String getUser(Principal principal,Model model){
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return  "users";
    }


    @GetMapping("/add-user")
    public String addUser(User user){
        return "add-user";
    }


    @PostMapping("/admin")
    public String saveUser(User user, Model model){
        userService.addUser(user);
        model.addAttribute("users", userService.getAllUser());
        return "redirect:/users";
    }


    @RequestMapping(value="/delete-user/{id}",method = RequestMethod.GET)
    public String deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return "redirect:/users";
    }
    @GetMapping("/update-user/{id}")
    public String updateUser(@PathVariable("id") Integer id, Model model){
        model.addAttribute("user", userService.get(id));
        return "update-user";
    }

    @RequestMapping(value = "/edit-user/{id}",method = RequestMethod.POST)
    public String editUser(@PathVariable("id") Integer id, User user){
        userService.updateUser(user, id);
        return "redirect:/users";
    }

}
