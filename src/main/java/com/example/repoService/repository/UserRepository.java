package com.example.repoService.repository;

import com.example.repoService.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "result", path = "user")
public interface UserRepository extends JpaRepository<User, Long> {

    @RestResource(path = "retrieve-user")
    User findUserById(Long id);
}
