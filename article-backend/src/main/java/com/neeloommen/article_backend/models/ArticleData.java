package com.neeloommen.article_backend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class ArticleData {
    @Getter @Setter private long id;
    @Getter @Setter private String author_name;
    @Getter @Setter private String title;
    @Getter @Setter private String articleBody;

}
