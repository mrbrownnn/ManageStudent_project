package com.fpt.booking.domain.payload.request;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fpt.booking.domain.enums.RoleName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class SignUpRequest {

    @NotBlank
    private String phone;

    @NotBlank
    private String password;

    private String confirmPassword;

    private RoleName role;
}