package com.discussion.community.controller;

import com.discussion.community.model.User;
import com.discussion.community.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jie
 */
@RestController
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/user")
    public String addUser(@RequestBody User user) {
        return service.addUser(user);
    }
}
