package com.neeloommen.article_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {
    //Data members
    private long id;
    private String userName;
    private String emailId;

    //Methods
    //Constructors
    //default
    public UserEntity(){
        //unused default
    }
    //parameterized
    public UserEntity(long _id, String _userName, String _emailId){
        this.id = _id;
        this.userName = _userName;
        this.emailId = _emailId;
    }

    //setters
    public void setId(long _id){
        this.id = _id;
    }

    public void setUserName(String _userName){
        this.userName = _userName;
    }

    public void setEmailId(String _emailId){
        this.emailId = _emailId;
    }

    //getters
    public long getId(){
        return this.id;
    }

    public String getUserName(){
        return this.userName;
    }

    public String getEmailId(){
        return this.emailId;
    }



}
