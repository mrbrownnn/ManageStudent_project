package com.fpt.manage.Springboot_Manage_app.security;
import lombok.Getter;
import org.springframework.security.authentication.event.AuthenticationFailureExpiredEvent;
import org.springframework.security.authentication.AuthenticationManager;
@Getter
public class Base_security {
    public static final String SECRET = "VerySecret";
    private static final long ExpriraionTime = 864_000_000;
    public static final String Token_ExpiraionTime = "Token_Expiraion";

}