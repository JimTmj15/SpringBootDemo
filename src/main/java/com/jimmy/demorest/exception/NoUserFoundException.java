package com.jimmy.demorest.exception;

public class NoUserFoundException extends RuntimeException {
    public NoUserFoundException(Long id) {
        super("User with ID: "+id.toString()+" not found");
    }
}
