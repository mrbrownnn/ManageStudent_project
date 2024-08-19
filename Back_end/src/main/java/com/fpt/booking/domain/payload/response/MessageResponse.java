package com.fpt.booking.domain.payload.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MessageResponse {
    private String errorCode;
    private String message;

    public MessageResponse(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }
}
