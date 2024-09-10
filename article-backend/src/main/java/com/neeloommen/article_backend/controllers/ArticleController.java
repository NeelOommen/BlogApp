package com.neeloommen.article_backend.controllers;

import com.neeloommen.article_backend.models.Article;
import com.neeloommen.article_backend.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles/")
public class ArticleController {
    //Data Members
    @Autowired
    private ArticleService articleService;

    //Methods
    //Constructors
    public ArticleController(ArticleService _articleService){
        this.articleService = _articleService;
    }

    @PostMapping("/create")
    public Article createArticle(@RequestBody Article _article){
        return articleService.createArticle(_article);
    }

    @GetMapping("/list_articles")
    public List<Article> getAllArticles(){
        return articleService.getAllArticles();
    }

    @GetMapping("/get_article/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable("id") long _id){
        Article article = null;
        article = articleService.getArticleById(_id);

        return ResponseEntity.ok(article);
    }


}
