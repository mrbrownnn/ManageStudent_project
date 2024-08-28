package com.fpt.booking.domain.payload.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    @NotBlank
    private String phone;

    // change phone into StudentID/TeacherID/MangerID

    @NotBlank
    private String password;
}