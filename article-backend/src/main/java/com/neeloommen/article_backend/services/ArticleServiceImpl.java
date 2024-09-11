package com.neeloommen.article_backend.services;

import com.neeloommen.article_backend.entity.ArticleEntity;
import com.neeloommen.article_backend.models.Article;
import com.neeloommen.article_backend.models.ArticleInfo;
import com.neeloommen.article_backend.repositories.ArticleRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
        this.listArticles = List.of(this.dummyArticle, this.dummyArticle, this.dummyArticle, this.dummyArticle);
    }



//    public ArticleServiceImpl(ArticleRepository _articleRepository){
//        //this.articleRepository = _articleRepository;
//
//        //DEBUG
//        this.dummyArticle = new Article(
//                1,
//                1,
//                "Article 1",
//                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent euismod urna in urna efficitur, ac volutpat eros elementum. Morbi vitae ultricies ligula, sed consequat ligula. Cras lobortis nisi ac dui dapibus dictum. Integer dictum est et risus efficitur, a aliquam dui malesuada. Mauris id ligula at libero fermentum consectetur. Nam bibendum mi non urna consequat, ac luctus purus auctor. Nulla facilisi. Phasellus vehicula magna ut ex efficitur, sed lacinia ligula tempor. Suspendisse potenti." +
//                        "                Nullam sed ornare velit. Donec auctor felis eget massa dapibus, at cursus ligula hendrerit. Fusce et ex ut urna sodales tempor. Duis at massa ultricies, tempus nunc ut, varius urna. Nullam tincidunt nibh id nisi iaculis, ac fermentum lectus scelerisque. Vivamus varius risus id urna tincidunt condimentum. Nam sed ipsum euismod, tristique libero nec, hendrerit urna. Donec faucibus nibh sit amet turpis tincidunt, a vehicula ligula aliquet." +
//                        "                Sed nec sapien vel libero volutpat volutpat. Proin lacinia velit eu nulla egestas feugiat. Aenean sit amet turpis a erat gravida eleifend. Fusce interdum lacus in auctor efficitur. Curabitur volutpat mauris nec urna aliquam, sed facilisis eros auctor. Duis consequat risus id ex tristique, id bibendum felis vestibulum. Vestibulum viverra dolor nec mauris ultricies convallis. Integer iaculis dui id ligula tempus, a viverra purus volutpat. Etiam sagittis odio non purus malesuada, a scelerisque ligula scelerisque. Suspendisse potenti." +
//                        "                Maecenas ultrices, ligula ac vehicula tincidunt, odio justo iaculis nisl, at vestibulum nunc dolor id risus. Aenean ultricies nisi a ligula cursus, ac scelerisque libero lacinia. Phasellus accumsan velit vel metus feugiat vehicula. Donec ultricies sapien quis sollicitudin rutrum. Nulla ornare risus nec nunc aliquet, non fermentum justo egestas. Vivamus ac turpis et libero facilisis tincidunt. Proin in purus nec ex luctus cursus. Donec sit amet metus lacinia, dictum libero sit amet, elementum libero. Sed lacinia lectus ut consectetur fermentum." +
//                        "                Fusce auctor turpis a lacus convallis, ac dapibus risus egestas. Donec dignissim velit id augue aliquam, a facilisis velit aliquam. Etiam efficitur odio ac urna lacinia, at ultricies purus viverra. Mauris a mi vel orci consectetur sagittis. Ut vitae nisi id risus cursus feugiat. In hac habitasse platea dictumst. Duis vehicula, metus nec tincidunt varius, ex mauris ultrices ligula, non volutpat nulla nisi in libero. Suspendisse pharetra orci ac est egestas interdum." +
//                        "                Phasellus at magna at eros euismod posuere. Vivamus egestas quam sed orci iaculis, id consectetur orci cursus. Integer vitae tincidunt elit. Sed interdum sapien sit amet enim dignissim, ut gravida ligula iaculis. Vestibulum vel sapien cursus, aliquam ligula a, facilisis ex. Aliquam erat volutpat. Cras viverra magna eget urna dignissim vestibulum. Pellentesque vel urna sit amet elit dictum egestas. Integer ut risus a magna vehicula bibendum." +
//                        "                Aliquam fringilla sapien vel arcu rhoncus, in varius magna rhoncus. Ut feugiat dui at nulla fringilla, non efficitur dolor dictum. Duis ac sapien et ex malesuada bibendum. Curabitur in erat nec elit dignissim congue. Donec consectetur arcu vitae nunc fermentum, et convallis nulla luctus. Nulla at metus sed ligula malesuada tincidunt. Cras a quam nec metus pretium volutpat sit amet eget purus. Ut facilisis libero a nisi bibendum, eget vehicula dui pharetra." +
//                        "                Proin nec vehicula sem. Suspendisse sollicitudin massa nec dui bibendum, nec convallis justo varius. Sed feugiat ipsum ut sem iaculis, nec fermentum odio malesuada. Nam iaculis orci in purus feugiat, non convallis libero aliquam. Phasellus facilisis est sit amet urna volutpat, ac cursus nulla elementum. Integer tincidunt leo ut arcu posuere, eget interdum nunc scelerisque. Vivamus vitae mi sed nisi iaculis tincidunt. Etiam aliquet metus et ligula fermentum, a tincidunt dolor vestibulum." +
//                        "                Donec ultrices, odio ac varius fringilla, est urna ultrices est, vel efficitur nunc odio eget felis. Suspendisse potenti. Phasellus sit amet purus vel tortor condimentum faucibus. Aenean a gravida ex, in fringilla erat. Integer congue malesuada diam, ut vehicula ligula dictum a. Vestibulum non libero quis sapien lacinia tincidunt. Proin suscipit, tortor sed dignissim ultricies, ante lacus feugiat arcu, ac bibendum turpis sapien a turpis. Aliquam eu urna nec enim fermentum fermentum." +
//                        "                Curabitur dapibus orci in risus gravida, vel pharetra dui viverra. Etiam convallis orci id nisi cursus, a bibendum elit auctor. Aliquam et nisi et turpis tempor scelerisque non eu elit. Vivamus id nunc id nisi fermentum vehicula. In id ligula vitae ipsum posuere convallis. Cras vel tincidunt felis, id suscipit est. Proin gravida libero vel ligula dignissim, et dictum purus cursus. Fusce sit amet risus ut lacus interdum fermentum." +
//                        "                Vestibulum gravida dui sed purus condimentum, et feugiat odio ullamcorper. In fringilla lacus sit amet mi venenatis, non tincidunt purus viverra. Nam interdum neque vitae ligula dictum condimentum. Aliquam feugiat felis eu bibendum sollicitudin. Quisque euismod dolor id purus fringilla, ac fermentum nunc maximus. Duis egestas nisi non velit eleifend, eget fringilla elit dapibus. Vivamus nec erat malesuada, venenatis sapien eget, vulputate urna." +
//                        "                Sed ut libero quis justo dictum pharetra nec sit amet urna. Proin vitae ipsum ut nisi cursus bibendum eget nec nisi. Nullam tincidunt ligula sed lorem dignissim, nec interdum justo sodales. Curabitur venenatis ipsum et magna interdum, ac tincidunt tortor scelerisque. Vivamus vitae velit ut nulla scelerisque fringilla ut et dolor. In eget felis sit amet odio egestas dignissim. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.");
//    }

    @Override
    public Article createArticle(Article _article) {
        ArticleEntity articleEntity = new ArticleEntity(
                _article.getId(),
                _article.getAuthorId(),
                _article.getTitle(),
                _article.getArticleBody());
        //articleRepository.save(articleEntity);

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
        List<Article> dummyList = List.of(this.dummyArticle);
        return dummyList;

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
