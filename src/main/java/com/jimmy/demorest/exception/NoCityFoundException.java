package com.jimmy.demorest.exception;

public class NoCityFoundException extends RuntimeException {
    public NoCityFoundException(Long id) {
        super("City with ID: "+id.toString()+" not found");
    }
}
