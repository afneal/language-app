package io.github.afneal.language_app_backend.services;

import io.github.afneal.language_app_backend.dto.request.LoginRequestDTO;
import io.github.afneal.language_app_backend.dto.request.RegisterRequestDTO;
import io.github.afneal.language_app_backend.models.User;
import io.github.afneal.language_app_backend.repositories.UserProfileRepository;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//service: login logic only
@Service
public class UserProfileService {

    private final PasswordEncoder passwordEncoder;
    private final UserProfileRepository userProfileRepository;

    public UserProfileService(PasswordEncoder passwordEncoder, UserProfileRepository userProfileRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userProfileRepository = userProfileRepository;
    }

    public void registerUser(RegisterRequestDTO registerRequest) {
        System.out.println(registerRequest.getUsername());

        if (userProfileRepository.existsByUsername(registerRequest.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

    User user = new User();
    user.setUsername(registerRequest.getUsername());
    user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

    userProfileRepository.save(user);
    }


    public User login(LoginRequestDTO loginRequest) {

        User user = userProfileRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Invalid Login");
        }
        return user;
    }


}
