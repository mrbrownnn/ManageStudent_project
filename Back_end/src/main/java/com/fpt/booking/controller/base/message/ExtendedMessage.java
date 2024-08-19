package com.fpt.booking.controller.base.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExtendedMessage<T> extends BaseMessage{
    private T data;

    public ExtendedMessage(String code, Boolean success, String message, String description, T data) {
        super(code, success, message, description);
        this.data = data;
    }
}

