package com.fpt.booking.controller.base.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseMessage {
    private String code;
    private Boolean success;
    private String message;
    private String description;
}


