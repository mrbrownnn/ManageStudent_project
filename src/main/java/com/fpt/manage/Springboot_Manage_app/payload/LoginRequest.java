package com.fpt.manage.Springboot_Manage_app.payload;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    @NotBlank
    private String StudentID;
    private String password;
}
