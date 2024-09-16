package com.neeloommen.article_backend.controllers;

import com.neeloommen.article_backend.entity.UserCredentialEntity;
import com.neeloommen.article_backend.entity.UserEntity;
import com.neeloommen.article_backend.models.User;
import com.neeloommen.article_backend.models.UserSignUp;
import com.neeloommen.article_backend.models.UserVerified;
import com.neeloommen.article_backend.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"},
methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("/api/user/")
public class UserController {
    //Data Members
    private UserService userService;

    //Methods
    //Constructors
    public UserController(UserService _userService){
        this.userService = _userService;
    }

    @PostMapping("/save")
    public UserEntity saveUser(@RequestBody UserSignUp _user){
        return userService.saveUser(_user);
    }

    @GetMapping("/show")
    public List<User> getUserList(){
        return userService.getUserList();
    }

    @PostMapping("/validate")
    public UserVerified validateUser(@RequestBody UserCredentialEntity _user){
        System.out.println("VALIDATION HIT");
        User checked = userService.validateUser(_user);
        if(checked == null){
            return null;
        }

        UserVerified result = new UserVerified(
                checked.getId(),
                checked.getUserName(),
                checked.getEmailId()
        );

        return result;
    }

}
