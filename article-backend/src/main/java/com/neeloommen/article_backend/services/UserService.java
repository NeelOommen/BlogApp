package com.neeloommen.article_backend.services;

import com.neeloommen.article_backend.entity.UserCredentialEntity;
import com.neeloommen.article_backend.models.User;
import com.neeloommen.article_backend.models.UserSignUp;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    User saveUser(UserSignUp _user);

    List<User> getUserList();

    User validateUser(UserCredentialEntity user);
}
