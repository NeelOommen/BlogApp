package com.neeloommen.article_backend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class UserVerified {
    @Getter @Setter private long _id;
    @Getter @Setter private String name;
    @Getter @Setter private String email;
}
