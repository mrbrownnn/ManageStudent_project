package com.fpt.manage.Springboot_Manage_app.controller.base.message;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExtendedMessage <T> extends BaseMessage{
    private T data;

    public ExtendedMessage(String code, Boolean success, String message, String description, T data) {
        super(code, success, message, description);
        this.data = data;
    }
// ke thua base message, them data vao message response
}
