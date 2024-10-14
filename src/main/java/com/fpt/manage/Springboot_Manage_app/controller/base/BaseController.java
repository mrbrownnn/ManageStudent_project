package com.fpt.manage.Springboot_Manage_app.controller.base;


import lombok.*;
import org.springframework.http.ResponseEntity;
import com.fpt.manage.Springboot_Manage_app.controller.base.message.BaseMessage;
import com.fpt.manage.Springboot_Manage_app.controller.base.message.ExtendedMessage;
import org.springframework.http.HttpStatus;

public abstract class BaseController {

    public <T> ResponseEntity<?> createSuccessResponse(String message, String description, T data) {
        ExtendedMessage<T> responseMessage = new ExtendedMessage<>(
                HttpStatus.OK.value() + "",
                true,
                message,
                description,
                data);
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    public ResponseEntity<?> createFailureResponse(String code, String message, String description) {
        BaseMessage responseMessage = new BaseMessage(
                code,
                false,
                message,
                description);
        return new ResponseEntity<>(responseMessage, HttpStatus.valueOf(Integer.parseInt(code)));
    }

    public <T> ResponseEntity<?> createSuccessResponse(String message, T data) {
        return createSuccessResponse(message, null, data);
    }

    public <T> ResponseEntity<?> createSuccessResponse(T data) {
        return createSuccessResponse(null, null, data);
    }

    public ResponseEntity<?> createSuccessResponse() {
        return createSuccessResponse(null, null, null);
    }

}


