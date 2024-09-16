package com.neeloommen.article_backend.services;

import com.neeloommen.article_backend.entity.ArticleEntity;
import com.neeloommen.article_backend.entity.UserEntity;
import com.neeloommen.article_backend.models.Article;
import com.neeloommen.article_backend.models.ArticleData;
import com.neeloommen.article_backend.models.ArticleInfo;
import com.neeloommen.article_backend.repositories.ArticleRepository;
import com.neeloommen.article_backend.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService{

    //Data Members
    private ArticleRepository articleRepository;
    private UserRepository userRepository;

    public ArticleServiceImpl(ArticleRepository _articleRepository, UserRepository _userRepository){
        this.articleRepository = _articleRepository;
        this.userRepository = _userRepository;
    }

    @Override
    public ArticleEntity createArticle(ArticleData _article) {
        //get author id
        UserEntity author = userRepository.findByUserName(_article.getAuthor_name());

        ArticleEntity newArticle = new ArticleEntity(
                author.getId(),
                _article.getTitle(),
                _article.getArticleBody()
        );
        articleRepository.save(newArticle);

        return newArticle;
    }

    @Override
    public List<Article> getAllArticles() {
        List<ArticleEntity> articleEntityList = articleRepository.findAll();

        List<Article> articleList = articleEntityList
                .stream()
                .map(articleEntity -> new Article(
                        articleEntity.getId(),
                        articleEntity.getAuthor_id(),
                        articleEntity.getTitle(),
                        articleEntity.getArticleBody()
                ))
                .collect(Collectors.toList());

        //DEBUG
        //return this.listArticles;

        return articleList;
    }

    @Override
    public ArticleData getArticleById(Long _id) {
        ArticleEntity articleEntity = articleRepository.findById(_id).get();
        Optional<UserEntity> user = userRepository.findById(articleEntity.getAuthor_id());

        if(user.isPresent()){
            UserEntity userEntity = user.get();

            ArticleData article = new ArticleData(
                    articleEntity.getId(),
                    userEntity.getUserName(),
                    articleEntity.getTitle(),
                    articleEntity.getArticleBody()
            );
            return article;
        }

        return null;
    }

    @Override
    public List<Long> getAllArticleIds() {
        List<ArticleEntity> articleList = articleRepository.findAll();

        List<Long> idList = articleList
                .stream()
                .map(articleEntity -> articleEntity.getId())
                .collect(Collectors.toList());

        return idList;
    }

    @Override
    public ArticleInfo getArticleInfoById(Long id) {
        Optional<ArticleEntity> temp = articleRepository.findById(id);
        if(temp.isPresent()){
            ArticleEntity obj = temp.get();
            //get corresponding user
            Optional<UserEntity> user = userRepository.findById(obj.getAuthor_id());
            if(user.isPresent()){
                UserEntity actualUser = user.get();
                ArticleInfo result = new ArticleInfo(actualUser.getUserName(), obj.getTitle());

                return result;
            }
        }

        return null;
    }
}
