package com.neeloommen.article_backend.services;

import com.neeloommen.article_backend.models.Article;
import com.neeloommen.article_backend.models.ArticleInfo;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

import java.util.List;

public interface ArticleService{
    Article createArticle(Article article);

    List<Article> getAllArticles();

    Article getArticleById(long _id);

    List<Long> getAllArticleIds();

    ArticleInfo getArticleInfoById(long id);
}
