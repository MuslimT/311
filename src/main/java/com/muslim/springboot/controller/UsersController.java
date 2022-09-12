package com.muslim.springboot.controller;

import com.muslim.springboot.model.User;
import com.muslim.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showAllUsers(Model model) {
        List<User> userList = userService.listUsers();
        model.addAttribute("allUsers", userList);
        return "users";
    }

    @GetMapping("addUser")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user-details";
    }

    @PutMapping("createUser")
    public String createUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @PostMapping("editUser")
    public String editUser(@RequestParam("userID") int id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "user-details";
    }

    @DeleteMapping("deleteUser")
    public String deleteUser(@RequestParam("userID") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
