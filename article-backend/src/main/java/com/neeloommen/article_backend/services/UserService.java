package com.neeloommen.article_backend.services;

import com.neeloommen.article_backend.models.User;

import java.util.List;

public interface UserService {
    User saveUser(User _user);

    List<User> getUserList();
}
