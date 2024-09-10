package com.neeloommen.article_backend.repositories;

import com.neeloommen.article_backend.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
