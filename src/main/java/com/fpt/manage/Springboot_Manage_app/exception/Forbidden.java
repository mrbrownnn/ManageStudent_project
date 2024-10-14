package com.fpt.manage.Springboot_Manage_app.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
// http status 403
public class Forbidden extends RuntimeException {
    public Forbidden(String message) {
        super(message);
    }

    public Forbidden(String message, Throwable cause) {
        super(message, cause);
    }
}
