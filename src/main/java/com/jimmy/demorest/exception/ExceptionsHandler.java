package com.jimmy.demorest.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoUserFoundException.class)
    public ResponseEntity<Object> handleNoUserFoundException(
            NoUserFoundException ex, WebRequest request) {

        Map<String, Object> body = new HashMap<>();
        body.put("status", "Fail");
        body.put("timestamp", LocalDateTime.now());
        body.put("message",ex.getLocalizedMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoCityFoundException.class)
    public ResponseEntity<Object> handleCityNotFoundException(
            NoCityFoundException ex, WebRequest request) {

        Map<String, Object> body = new HashMap<>();
        body.put("status", "Fail");
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "City not found");

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoDataException.class)
    public ResponseEntity<Object> handleNoDataException(
            NoDataException ex, WebRequest request) {

        Map<String, Object> body = new HashMap<>();
        body.put("status", "Fail");
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Data not found");

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {

        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", status.value());

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        body.put("status", "Fail");
        body.put("message", "Bad Request");
        body.put("errors", errors);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
