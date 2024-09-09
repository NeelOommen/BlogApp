package com.neeloommen.article_backend.repositories;

import com.neeloommen.article_backend.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {
}
