package com.neeloommen.article_backend.services;

import com.neeloommen.article_backend.models.Article;

import java.util.List;

public interface ArticleService{
    Article createArticle(Article article);

    List<Article> getAllArticles();

    Article getArticleById(long _id);
}
