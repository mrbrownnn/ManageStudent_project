package com.fpt.manage.Springboot_Manage_app.exception;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.AuthenticationException;
public class OAuth2AuthenticationProcessingException extends AuthenticationException {
    // extends AuthenticationException im spring security
    public OAuth2AuthenticationProcessingException(String msg, Throwable t) {
        super(msg, t);
    }

    public OAuth2AuthenticationProcessingException(String msg) {
        super(msg);
    }
}

