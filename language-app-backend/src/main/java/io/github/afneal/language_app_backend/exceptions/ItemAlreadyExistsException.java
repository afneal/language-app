package io.github.afneal.language_app_backend.exceptions;

public class ItemAlreadyExistsException extends RuntimeException{

    public ItemAlreadyExistsException(String message) {
        super(message); //passes message to parent exception system (RuntimeException)
                            //always use super() in custom exceptions
    }
}
