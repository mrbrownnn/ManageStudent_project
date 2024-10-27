package com.ptit.studentmanagement.domain.payload.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountRequest {
    @NotBlank(message = "Username is required")
    private String username;

    @Size(min = 6, max = 40)
    private String password;

    private String studentId;
}
