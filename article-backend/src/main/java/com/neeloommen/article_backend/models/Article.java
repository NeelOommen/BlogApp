package com.neeloommen.article_backend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Article {
    //Data Members
    private Long id;
    private Long author_id;
    private String title;
    private String articleBody;
}
