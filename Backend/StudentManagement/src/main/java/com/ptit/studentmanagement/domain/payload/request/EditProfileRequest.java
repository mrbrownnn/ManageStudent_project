package com.ptit.studentmanagement.domain.payload.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class EditProfileRequest {
    @NotBlank(message = "StudentID is required")
    private String studentId;
    @NotBlank(message = "Fullname is required")
    private String studentName;
    private LocalDateTime birthdate;
    private String courseYear;
    private String hometown;
    private String address;
    //edit profile
}
