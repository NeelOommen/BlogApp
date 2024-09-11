package com.neeloommen.article_backend.services;

import com.neeloommen.article_backend.entity.ArticleEntity;
import com.neeloommen.article_backend.models.Article;
import com.neeloommen.article_backend.models.ArticleInfo;
import com.neeloommen.article_backend.repositories.ArticleRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService{

    //Data Members
    //private ArticleRepository articleRepository;

    //DEBUG
    private Article dummyArticle;
    private List<Article> listArticles;

    //Methods
    //Constructors
    public ArticleServiceImpl(){
        //DEBUG
        this.dummyArticle = new Article(
                1,
                1,
                "Article 1",
                "Scientists say they have discovered a new species of orangutans on Indonesia’s island of Sumatra.\n" +
                        "The population differs in several ways from the two existing orangutan species found in Sumatra and the neighboring island of Borneo.\n" +
                        "The orangutans were found inside North Sumatra’s Batang Toru forest, the science publication Current Biology reported.\n" +
                        "Researchers named the new species the Tapanuli orangutan. They say the animals are considered a new species because of genetic, skeletal and tooth differences.\n" +
                        "Michael Kruetzen is a geneticist with the University of Zurich who has studied the orangutans for several years. He said he was excited to be part of the unusual discovery of a new great ape in the present day. He noted that most great apes are currently considered endangered or severely endangered.\n" +
                        "Gorillas, chimpanzees and bonobos also belong to the great ape species.\n" +
                        "Orangutan – which means person of the forest in the Indonesian and Malay languages - is the world’s biggest tree-living mammal. The orange-haired animals can move easily among the trees because their arms are longer than their legs. They live more lonely lives than other great apes, spending a lot of time sleeping and eating fruit in the forest.\n" +
                        "The new study said fewer than 800 of the newly-described orangutans exist. Their low numbers make the group the most endangered of all the great ape species.\n" +
                        "They live within an area covering about 1,000 square kilometers. The population is considered highly vulnerable. That is because the environment which they depend on is greatly threatened by development.\n" +
                        "Researchers say if steps are not taken quickly to reduce the current and future threats, the new species could become extinct “within our lifetime.”\n" +
                        "Research into the new species began in 2013, when an orangutan protection group in Sumatra found an injured orangutan in an area far away from the other species. The adult male orangutan had been beaten by local villagers and died of his injuries. The complete skull was examined by researchers.\n" +
                        "Among the physical differences of the new species are a notably smaller head and frizzier hair. The Tapanuli orangutans also have a different diet and are found only in higher forest areas.\n" +
                        "There is no unified international system for recognizing new species. But to be considered, discovery claims at least require publication in a major scientific publication.\n" +
                        "Russell Mittermeier is head of the primate specialist group at the International Union for the Conservation of Nature. He called the finding a “remarkable discovery.” He said it puts responsibility on the Indonesian government to help the species survive.\n" +
                        "Matthew Nowak is one of the writers of the study. He told the Associated Press that there are three groups of the Tapanuli orangutans that are separated by non-protected land.He said forest land needs to connect the separated groups.\n" +
                        "In addition, the writers of the study are recommending that plans for a hydropower center in the area be stopped by the government.\n" +
                        "It also recommended that remaining forest in the Sumatran area where the orangutans live be protected.\n" +
                        "I’m Bryan Lynn.");
        this.listArticles = new ArrayList<>();
        this.listArticles.add(this.dummyArticle);
        this.listArticles.add(this.dummyArticle);
        this.listArticles.add(this.dummyArticle);
        this.listArticles.add(this.dummyArticle);
    }



//    public ArticleServiceImpl(ArticleRepository _articleRepository){
//        //this.articleRepository = _articleRepository;
//
//        //DEBUG
//
//    }

    @Override
    public Article createArticle(Article _article) {
        ArticleEntity articleEntity = new ArticleEntity(
                _article.getId(),
                _article.getAuthorId(),
                _article.getTitle(),
                _article.getArticleBody());
        //articleRepository.save(articleEntity);

        this.listArticles.add(_article);

        return _article;
    }

    @Override
    public List<Article> getAllArticles() {
//        List<ArticleEntity> articleEntityList = articleRepository.findAll();

//        List<Article> articleList = articleEntityList
//                .stream()
//                .map(articleEntity -> new Article(
//                        articleEntity.getId(),
//                        articleEntity.getAuthorId(),
//                        articleEntity.getTitle(),
//                        articleEntity.getArticleBody()
//                ))
//                .collect(Collectors.toList());

        //DEBUG
        return this.listArticles;

        //return articleList;
    }

    @Override
    public Article getArticleById(long _id) {
//        ArticleEntity articleEntity = articleRepository.findById(_id).get();
//        Article article = new Article(
//                articleEntity.getId(),
//                articleEntity.getAuthorId(),
//                articleEntity.getTitle(),
//                articleEntity.getArticleBody()
//        );
//        return article;

        //DEBUG
        return this.dummyArticle;
    }

    @Override
    public List<Long> getAllArticleIds() {
        List<Long> idList = this.listArticles
                .stream()
                .map(article -> article.getId())
                .collect(Collectors.toList());

        return idList;
    }

    @Override
    public ArticleInfo getArticleInfoById(long id) {
        //Debug

        ArticleInfo temp = new ArticleInfo(this.dummyArticle.getAuthorId(), this.dummyArticle.getTitle());

        return temp;
    }
}
