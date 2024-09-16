package com.neeloommen.article_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="articles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArticleEntity {
    //Data Members
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "author_id")
    private Long author_id;

    @Column(name = "title")
    private String title;

    @Column(name = "article_body")
    private String articleBody;

    public ArticleEntity(Long _author_id, String _title, String _body){
        this.author_id = _author_id;
        this.title = _title;
        this.articleBody = _body;
    }
}
