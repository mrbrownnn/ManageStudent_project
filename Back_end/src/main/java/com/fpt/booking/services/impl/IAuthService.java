package com.fpt.booking.services.impl;

import com.fpt.booking.common.CommonMapper;
import com.fpt.booking.config.ResourceBundleConfig;
import com.fpt.booking.domain.entities.Role;
import com.fpt.booking.domain.entities.User;
import com.fpt.booking.domain.enums.AuthProvider;
import com.fpt.booking.domain.enums.RoleName;
import com.fpt.booking.domain.payload.request.LoginRequest;
import com.fpt.booking.domain.payload.request.SignUpRequest;
import com.fpt.booking.domain.payload.response.AuthResponse;
import com.fpt.booking.domain.payload.response.UserResponse;
import com.fpt.booking.exception.BadRequestException;
import com.fpt.booking.repository.RoleRepository;
import com.fpt.booking.repository.UserRepository;
import com.fpt.booking.secruity.TokenProvider;
import com.fpt.booking.services.AuthService;
import com.fpt.booking.utils.MessageUtils;
import com.fpt.booking.utils.Regex;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Collections;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class IAuthService extends BaseService implements AuthService {

    private final UserRepository userRepository;

    private final AuthenticationManager authenticationManager;

    private final RoleRepository roleRepository;

    private final ResourceBundleConfig resourceBundleConfig;

    private final TokenProvider tokenProvider;

    private final PasswordEncoder passwordEncoder;
    private final CommonMapper commonMapper;

    @Override
    public void registerAccount(SignUpRequest signUpRequest) {
        if (!isValidVietnamesePhoneNumber(signUpRequest.getPhone())) {
            throw new BadRequestException(this.resourceBundleConfig.getViMessage(MessageUtils.PHONE_VALIDATE));
        }

        if (userRepository.existsByPhone(signUpRequest.getPhone())) {
            throw new BadRequestException(this.resourceBundleConfig.getViMessage(MessageUtils.PHONE_USED));
        }

        if (!isValidPassword(signUpRequest.getPassword())) {
            throw new BadRequestException(this.resourceBundleConfig.getViMessage(MessageUtils.PASSWORD_NOT_VALIDATE));
        }

        if (!signUpRequest.getPassword().equals(signUpRequest.getConfirmPassword())) {
            throw new BadRequestException(this.resourceBundleConfig.getViMessage(MessageUtils.PASSWORD_NOT_CONFIRMED));
        }
        User user = new User(signUpRequest.getPhone(),
                passwordEncoder.encode(signUpRequest.getPassword()),
                AuthProvider.local,
                false,
                false);
        if (RoleName.ROLE_USER.equals(signUpRequest.getRole())) {
            Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                    .orElseThrow(() -> new IllegalArgumentException(this.resourceBundleConfig.getViMessage(MessageUtils.ROLE_EMPTY)));

            user.setRoles(Collections.singleton(userRole));
            userRepository.save(user);

        } else if (RoleName.ROLE_DRIVER.equals(signUpRequest.getRole())) {
            Role userRole = roleRepository.findByName(RoleName.ROLE_DRIVER)
                    .orElseThrow(() -> new IllegalArgumentException(this.resourceBundleConfig.getViMessage(MessageUtils.ROLE_EMPTY)));
            user.setRoles(Collections.singleton(userRole));
            userRepository.save(user);
        } else {
            throw new IllegalArgumentException(this.resourceBundleConfig.getViMessage(MessageUtils.NOT_CREATED_ACCOUNT));
        }
        ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/user/me")
                .buildAndExpand(user.getId()).toUri();
    }

    @Override
    public AuthResponse login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getPhone(),
                        loginRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.createToken(authentication);
        Long userId = tokenProvider.getUserIdFromToken(jwt);
        User user = userRepository.findById(userId).orElseThrow(() -> new BadRequestException(this.resourceBundleConfig.getViMessage(MessageUtils.USER_NOT_FOUND)));
        Set<Role> roles = user.getRoles();

        for (Role role : roles) {
            if (RoleName.ROLE_ADMIN.equals(role.getName())) {
                return new AuthResponse(jwt, RoleName.ROLE_ADMIN.getValue());
            } else if (RoleName.ROLE_USER.equals(role.getName())) {
                return new AuthResponse(jwt, RoleName.ROLE_USER.getValue());
            } else if (RoleName.ROLE_DRIVER.equals(role.getName())) {
                return new AuthResponse(jwt, RoleName.ROLE_DRIVER.getValue());
            } else {
                throw new BadRequestException(this.resourceBundleConfig.getViMessage(MessageUtils.ROLE_EMPTY));
            }
        }
        return new AuthResponse(jwt);
    }

    @Override
    public UserResponse getInformationOfAccount() {
        return commonMapper.convertToResponse(getAccountById(), UserResponse.class);
    }

    public static boolean isValidVietnamesePhoneNumber(String phoneNumber) {
        return Pattern.matches(Regex.PHONE_VALIDATION, phoneNumber);
    }

    public static boolean isValidPassword(String password) {
        Pattern pattern = Pattern.compile(Regex.PASSWORD_VALIDATION);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    private User getAccountById(){
        return  userRepository.findById(getUserId()).orElseThrow(() ->  new BadRequestException(this.resourceBundleConfig.getViMessage(MessageUtils.ACCOUNT_NOT_FOUND)));
    }
}
