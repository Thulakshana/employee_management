package org.example.hibye.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidUsernameException.class)
    public ResponseEntity<String> handleInvalidUsernameException(InvalidUsernameException ex) {
        return ResponseEntity
                .badRequest()
                .body(ex.getMessage());
    }

    @ExceptionHandler(InvalidPasswordException.class)public ResponseEntity<String>handleInvallidPasswordException(InvalidPasswordException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}