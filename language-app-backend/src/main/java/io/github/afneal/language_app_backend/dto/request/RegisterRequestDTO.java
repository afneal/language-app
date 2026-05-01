package io.github.afneal.language_app_backend.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterRequestDTO {

    //validation in request since frontend is sending to backend
    @NotBlank(message = "Username is required.")
    @Size(min = 3, max = 20, message = "Username must be 3-20 characters long.")
    private String username;

    @NotBlank(message = "Password is required.")
    @Size(min = 8, message = "Password must be at least 8 characters long.")
    private String password;

    public RegisterRequestDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public RegisterRequestDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
