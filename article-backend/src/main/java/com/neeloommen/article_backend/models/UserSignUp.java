package com.neeloommen.article_backend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserSignUp {
    private long id;
    private String email;
    private String username;
    private String password;
}
