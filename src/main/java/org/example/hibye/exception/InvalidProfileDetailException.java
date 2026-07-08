package org.example.hibye.exception;

public class InvalidProfileDetailException extends RuntimeException{
    public InvalidProfileDetailException(String message){
        super(message);
    }
}
