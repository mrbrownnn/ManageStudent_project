package com.fpt.booking.services;

import com.fpt.booking.domain.payload.request.LoginRequest;
import com.fpt.booking.domain.payload.request.SignUpRequest;
import com.fpt.booking.domain.payload.response.AuthResponse;
import com.fpt.booking.domain.payload.response.UserResponse;

public interface AuthService {
    void registerAccount(SignUpRequest signUpRequest);

    AuthResponse login(LoginRequest loginRequest);

    UserResponse getInformationOfAccount();
}
