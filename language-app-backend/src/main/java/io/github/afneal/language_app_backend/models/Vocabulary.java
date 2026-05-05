package io.github.afneal.language_app_backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Vocabulary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonBackReference //JPA/hibernate expects Object relationships, not ids for mapping (so not private int userId -> has no relational mapping).
    //User user = full user object. int userId = only a number
    @JoinColumn(name = "user_id") //to specifically name the foreign key column in db
    @ManyToOne
    private User user;

    private String wordText;

    private String translation;

    private String sentence;
}
