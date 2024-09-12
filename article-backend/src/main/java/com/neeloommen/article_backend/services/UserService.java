package com.neeloommen.article_backend.services;

import com.neeloommen.article_backend.entity.UserCredentialEntity;
import com.neeloommen.article_backend.models.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    User saveUser(User _user);

    List<User> getUserList();

    ResponseEntity<User> validateUser(UserCredentialEntity user);
}
