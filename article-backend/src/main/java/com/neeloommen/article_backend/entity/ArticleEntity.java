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
public class ArticleEntity {
    //Data Members
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter private Long id;

    @Column(name = "author_id")
    @Getter @Setter private Long author_id;

    @Column(name = "title")
    @Getter @Setter private String title;

    @Column(name = "article_body")
    @Getter @Setter private String articleBody;
}
