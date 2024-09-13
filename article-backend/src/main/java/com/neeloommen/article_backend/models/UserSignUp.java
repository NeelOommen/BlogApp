package com.neeloommen.article_backend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class UserSignUp {
    @Getter @Setter private String email;
    @Getter @Setter private String username;
    @Getter @Setter private String password;
}
