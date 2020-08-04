package com.jimmy.demorest.exception;

public class NoDataException extends RuntimeException {
    public NoDataException() {
        super("No data found");
    }
}
