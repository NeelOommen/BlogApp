package com.neeloommen.article_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    //Data members
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter private long id;

    @Column(name = "user_name")
    @Getter @Setter private String userName;

    @Column(name = "email_id")
    @Getter @Setter private String emailId;

}
