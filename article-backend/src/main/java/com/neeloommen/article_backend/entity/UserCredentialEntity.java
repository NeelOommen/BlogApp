package com.neeloommen.article_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="credentials")
@NoArgsConstructor
@AllArgsConstructor
public class UserCredentialEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter private long id;

    @Column(name="email")
    @Getter @Setter private String email;

    @Column(name="password")
    @Getter @Setter private String password;
}
