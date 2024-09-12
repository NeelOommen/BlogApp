package com.neeloommen.article_backend.services;

import com.neeloommen.article_backend.models.Article;
import com.neeloommen.article_backend.models.ArticleData;
import com.neeloommen.article_backend.models.ArticleInfo;

import java.util.List;

public interface ArticleService{
    Article createArticle(Article article);

    List<Article> getAllArticles();

    ArticleData getArticleById(Long _id);

    List<Long> getAllArticleIds();

    ArticleInfo getArticleInfoById(Long id);
}
