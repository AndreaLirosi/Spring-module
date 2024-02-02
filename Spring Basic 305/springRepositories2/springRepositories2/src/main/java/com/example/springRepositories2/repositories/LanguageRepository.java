package com.example.springRepositories2.repositories;

import com.example.springRepositories2.entities.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.Description;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path = "repo-prog-languages", collectionResourceDescription= @Description("qui va la descrizione"))
public interface LanguageRepository extends JpaRepository<Language, Long> {
}
