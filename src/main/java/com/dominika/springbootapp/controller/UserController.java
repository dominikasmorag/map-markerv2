package com.dominika.springbootapp.controller;

import com.dominika.springbootapp.entity.User;
import com.dominika.springbootapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="api/v1/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value="/current")
    public Long currentUserId() {
        return userService.currentUserId();
    }

    @GetMapping
    public User currentUser() { return userService.currentUser(); }

}
