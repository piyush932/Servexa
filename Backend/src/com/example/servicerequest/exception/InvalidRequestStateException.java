package com.example.servicerequest.exception;

public class InvalidRequestStateException extends RuntimeException{
    public InvalidRequestStateException(String message) {
        super(message);
    }
}
