package com.Gorbunov.springbootapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.Gorbunov.springbootapp.model.User;
import com.Gorbunov.springbootapp.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String printUsers(ModelMap modelMap, @RequestParam(required = false) final Long id) {
        modelMap.addAttribute("users", userService.getUserList());
        if (id == null) {
            modelMap.addAttribute("user", new User());
        } else {
            modelMap.addAttribute("user", userService.getUserById(id));
        }
        return "index";
    }

    @GetMapping("/deleteUser")
    public String deleteEmployee(@RequestParam Long userId) {
        userService.deleteUser(userId);
        return "redirect:/";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute User user) {
        if (user.getId() == null) {
            userService.addUser(user);
        } else {
            userService.updateUser(user);
        }
        return "redirect:/";
    }
}
