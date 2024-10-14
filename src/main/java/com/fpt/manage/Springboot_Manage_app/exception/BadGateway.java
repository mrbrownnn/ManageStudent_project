package com.fpt.manage.Springboot_Manage_app.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_GATEWAY)
// http status 502
public class BadGateway extends RuntimeException {
    public BadGateway(String message) {
        super(message);
    }

    public BadGateway(String message, Throwable cause) {
        super(message, cause);
    }
}
