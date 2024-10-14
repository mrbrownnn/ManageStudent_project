package com.fpt.manage.Springboot_Manage_app.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {
    public BadRequestException (String message){
        super(message);
    }
    public BadRequestException(String message, Throwable cause) {

        super(message, cause);
    }
    // http status 400
}
