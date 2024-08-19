package com.fpt.booking.controller.base;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Objects;

@ControllerAdvice
public class ControllerExceptionHandler extends BaseController {


    @org.springframework.web.bind.annotation.ExceptionHandler({ MethodArgumentNotValidException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> handleException(MethodArgumentNotValidException e) {
        return createFailureResponse(
                HttpStatus.BAD_REQUEST.value() + "",
                Objects.requireNonNull(e.getFieldError()).getDefaultMessage(),
                null);
    }


    @org.springframework.web.bind.annotation.ExceptionHandler({ IllegalArgumentException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> handleException(IllegalArgumentException e) {
        return createFailureResponse(
                HttpStatus.BAD_REQUEST.value() + "",
                e.getMessage(),
                null);
    }


    @org.springframework.web.bind.annotation.ExceptionHandler({ Exception.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<?> handleException(Exception e) {
        return createFailureResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value() + "",
                e.getMessage(),
                null);
    }
}

