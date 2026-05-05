package io.github.afneal.language_app_backend.services;

import io.github.afneal.language_app_backend.models.Vocabulary;
import io.github.afneal.language_app_backend.repositories.VocabularyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VocabularyService {

    private final VocabularyRepository vocabularyRepository;

    public VocabularyService(VocabularyRepository vocabularyRepository) {
        this.vocabularyRepository = vocabularyRepository;
    }

//GET logic
    public List<Vocabulary> getVocabularyByUserId(int userId) {
        return vocabularyRepository.findByUserId(userId);
    }




}
