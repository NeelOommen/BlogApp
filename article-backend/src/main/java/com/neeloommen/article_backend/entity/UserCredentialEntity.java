package com.neeloommen.article_backend.entity;

import com.neeloommen.article_backend.repositories.UserCredentialsRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="credentials")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserCredentialEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    public UserCredentialEntity(String _email, String _password){
        this.email = _email;
        this.password = _password;
    }
}
