package io.github.afneal.language_app_backend.exceptions;

import java.util.List;

public class ErrorResponse {

    private Integer statusCode;
    private List<String> message;
    private String error;

    public ErrorResponse() { }

    public ErrorResponse(Integer statusCode, List<String> message, String error) {
        this.statusCode = statusCode;
        this.message = message;
        this.error = error;
    }

    public Integer getStatusCode() { return statusCode; }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public List<String> getMessage() { return message; }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    public String getError() { return error; }

    public void setError(String error) {
        this.error = error;
    }
}
