package com.neeloommen.article_backend.models;

public class Article {
    //Data Members
    private Long id;
    private Long author_id;
    private String title;
    private String articleBody;

    //Methods
    //Constructors
    //Default
    public Article(){
        //unused
    }

    public Article(Long _id, Long _author_id, String _title, String _article_body){
        this.id = _id;
        this.author_id = _author_id;
        this.title = _title;
        this.articleBody = _article_body;
    }

    //setters
    public void setId(Long _id){
        this.id = _id;
    }

    public void setAuthorId(Long _author_id){
        this.author_id = _author_id;
    }

    public void setTitle(String _title){
        this.title = _title;
    }

    public void setArticleBody(String _articleBody){
        this.articleBody = _articleBody;
    }

    //getters
    public Long getId(){
        return this.id;
    }

    public Long getAuthorId(){
        return this.author_id;
    }

    public String getTitle(){
        return this.title;
    }

    public String getArticleBody(){
        return this.articleBody;
    }
}
