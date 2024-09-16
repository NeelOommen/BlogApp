package com.neeloommen.article_backend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArticleData {
    private long id;
    private String title;
    private String author_name;
    private String articleBody;

    public ArticleData(String _aName, String _title, String _body){
        this.author_name = _aName;
        this.title = _title;
        this.articleBody = _body;
    }
}
