package com.neeloommen.article_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "articles")
public class ArticleEntity {
    //Data Members
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long author_id;
    private String title;
    private String articleBody;

    //Methods
    //Constructors
    //Default
    public ArticleEntity(){
        //unused
    }

    public ArticleEntity(long _id, long _author_id, String _title, String _article_body){
        this.id = _id;
        this.author_id = _author_id;
        this.title = _title;
        this.articleBody = _article_body;
    }

    //setters
    public void setId(long _id){
        this.id = _id;
    }

    public void setAuthorId(long _author_id){
        this.author_id = _author_id;
    }

    public void setTitle(String _title){
        this.title = _title;
    }

    public void setArticleBody(String _articleBody){
        this.articleBody = _articleBody;
    }

    //getters
    public long getId(){
        return this.id;
    }

    public long getAuthorId(){
        return this.author_id;
    }

    public String getTitle(){
        return this.title;
    }

    public String getArticleBody(){
        return this.articleBody;
    }
}
