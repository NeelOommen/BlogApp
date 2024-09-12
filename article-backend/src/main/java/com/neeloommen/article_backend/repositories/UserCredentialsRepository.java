package com.neeloommen.article_backend.repositories;

import com.neeloommen.article_backend.entity.UserCredentialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCredentialsRepository extends JpaRepository<UserCredentialEntity, Long> {

    UserCredentialEntity findByEmail(String email);
}
