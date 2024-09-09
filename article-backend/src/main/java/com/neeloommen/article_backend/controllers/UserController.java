package com.neeloommen.article_backend.controllers;

import com.neeloommen.article_backend.models.User;
import com.neeloommen.article_backend.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/")
public class UserController {
    //Data Members
    private UserService userService;

    //Methods
    //Constructors
    public UserController(UserService _userService){
        this.userService = _userService;
    }

    @PostMapping("/user")
    public User saveUser(@RequestBody User _user){
        return userService.saveUser(_user);
    }

    @GetMapping("/user")
    public List<User> getUserList(){
        return userService.getUserList();
    }

}
