package com.neeloommen.article_backend.services;

import com.neeloommen.article_backend.entity.ArticleEntity;
import com.neeloommen.article_backend.models.Article;
import com.neeloommen.article_backend.repositories.ArticleRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ArticleServiceImpl implements ArticleService{

    //Data Members
    private ArticleRepository articleRepository;

    //Methods
    //Constructors
    public ArticleServiceImpl(ArticleRepository _articleRepository){
        this.articleRepository = _articleRepository;
    }

    @Override
    public Article createArticle(Article _article) {
        ArticleEntity articleEntity = new ArticleEntity(
                _article.getId(),
                _article.getAuthorId(),
                _article.getTitle(),
                _article.getArticleBody());
        articleRepository.save(articleEntity);

        return _article;
    }

    @Override
    public List<Article> getAllArticles() {
        List<ArticleEntity> articleEntityList = articleRepository.findAll();

        List<Article> articleList = articleEntityList
                .stream()
                .map(articleEntity -> new Article(
                        articleEntity.getId(),
                        articleEntity.getAuthorId(),
                        articleEntity.getTitle(),
                        articleEntity.getArticleBody()
                ))
                .collect(Collectors.toList());

        return articleList;
    }

    @Override
    public Article getArticleById(long _id) {
        ArticleEntity articleEntity = articleRepository.findById(_id).get();
        Article article = new Article(
                articleEntity.getId(),
                articleEntity.getAuthorId(),
                articleEntity.getTitle(),
                articleEntity.getArticleBody()
        );
        return article;
    }
}
