package io.github.afneal.language_app_backend.controllers;


import io.github.afneal.language_app_backend.models.Vocabulary;
import io.github.afneal.language_app_backend.services.VocabularyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/vocabulary")
public class VocabularyController {

    private final VocabularyService vocabularyService;

    public VocabularyController(VocabularyService vocabularyService) {
        this.vocabularyService = vocabularyService;
    }

    @GetMapping("/{userId}")
    public List<Vocabulary> getVocabularyByUserId(@PathVariable int userId){
        return vocabularyService.getVocabularyByUserId(userId);
    }



}
