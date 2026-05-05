package io.github.afneal.language_app_backend.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.List;
import java.util.stream.Collectors;

//errors only
@RestControllerAdvice
public class GlobalExceptionHandler {

    //business conflicts(409)
    @ExceptionHandler(ItemAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleItemAlreadyExistsException(ItemAlreadyExistsException exception) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.CONFLICT.value(),
                List.of(exception.getMessage()),
                "CONFLICT"
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    //missing data(404)
    @ExceptionHandler(ResourceNotFoundException.class) //custom handler for missing users, words, missing flashcard etc
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException exception) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                List.of(exception.getMessage()), //need to use List.of since ErrorResponse (DTO) has message as List
                "NOT_FOUND"
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    //validation errors(400)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    //handles validation errors like @size, password, empty username
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<String> errors = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(field -> field.getDefaultMessage())
                .toList();

        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                errors,
                "VALIDATION_ERROR"
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }


}
