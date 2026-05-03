package io.github.afneal.language_app_backend.controllers;


import io.github.afneal.language_app_backend.dto.request.LoginRequestDTO;
import io.github.afneal.language_app_backend.dto.request.RegisterRequestDTO;
import io.github.afneal.language_app_backend.exceptions.ErrorResponse;
import io.github.afneal.language_app_backend.models.User;
import io.github.afneal.language_app_backend.repositories.UserProfileRepository;
import io.github.afneal.language_app_backend.services.UserProfileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//controller: HTTP only
@RestController
@RequestMapping("/api/user")
public class AuthController {

    //better than using Autowired b/c can use final and prevent unauthorized changes and keeps "final" fields immutable.
    //Autowired is legacy Spring

    //should not inject repositories into controller, only service use
    private final UserProfileService userProfileService;

    //constructor injection for service only in controller
    public AuthController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody @Valid LoginRequestDTO loginRequest) {
        User user = userProfileService.login(loginRequest);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody @Valid RegisterRequestDTO registerRequest) {
        System.out.println("register endpoint hit");
        userProfileService.registerUser(registerRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }
}
