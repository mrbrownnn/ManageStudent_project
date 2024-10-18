package com.ptit.studentmanagement.domain.playload.request;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Optional;

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
