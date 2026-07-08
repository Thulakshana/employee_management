package org.example.hibye.exception;

public class InvalidUsernameException extends RuntimeException {

    public InvalidUsernameException(String message) {
        super(message);
    }
}