package com.neeloommen.article_backend.models;

public class ArticleInfo {
    private String author_id;
    private String title;

    public ArticleInfo(String _aId, String _title){
        this.author_id = _aId;
        this.title = _title;
    }

    public void setTitle(String _title){
        this.title = _title;
    }

    public void setAuthor_id(String _aId){
        this.author_id = _aId;
    }

    public String getAuthor_id(){
        return this.author_id;
    }

    public String getTitle(){
        return this.title;
    }
}
