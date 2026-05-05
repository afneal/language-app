package io.github.afneal.language_app_backend.repositories;

import io.github.afneal.language_app_backend.models.User;
import io.github.afneal.language_app_backend.models.Vocabulary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VocabularyRepository extends JpaRepository<Vocabulary, Integer> {
    //<Entity, ID_Type>

    List<Vocabulary> findByUserId(int userId);
}
