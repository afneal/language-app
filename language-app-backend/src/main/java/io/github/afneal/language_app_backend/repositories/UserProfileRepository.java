package io.github.afneal.language_app_backend.repositories;

import io.github.afneal.language_app_backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserProfileRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username); //so that services can optionally find user, forces the service to handle the "not found" case with thrown exception
    //other outdate option is "User findByUsername(String username);: returns null if nothing found, can cause crash
    boolean existsByUsername(String username);
}
