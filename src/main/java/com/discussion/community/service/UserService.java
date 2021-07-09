package com.discussion.community.service;

import com.discussion.community.model.User;
import org.springframework.stereotype.Service;

/**
 * @author jie
 */
@Service
public class UserService {

    public String addUser(User user) {
        return "OK " + user.getName();
    }
}
