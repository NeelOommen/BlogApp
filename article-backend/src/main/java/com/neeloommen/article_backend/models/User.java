package com.neeloommen.article_backend.models;

public class User {
    //Data members
    private long id;
    private String userName;
    private String emailId;

    //Methods
    //Constructors
    //default
    public User(){
        //unused default
    }

    //parameterized
    public User(long _id, String _userName, String _emailId){
        this.id = _id;
        this.userName = _userName;
        this.emailId = _emailId;
    }

    //setters
    public void setId(Long _id){
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
