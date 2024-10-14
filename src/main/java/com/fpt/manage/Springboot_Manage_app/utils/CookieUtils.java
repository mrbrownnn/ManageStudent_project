package com.fpt.manage.Springboot_Manage_app.utils;
import com.nimbusds.oauth2.sdk.Request;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.util.SerializationUtils;

import java.util.Base64;
import java.util.Optional;
import java.util.HashSet;

public class CookieUtils {
    public static Optional<Cookie> getCookies(HttpServletRequest request, String name) {
        Cookie [] cookies = request.getCookies();
        if( cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    return Optional.of(cookie);
                }
            }
        }
        return Optional.empty();
    }
    public static Optional<Cookie> AddCookie (HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
        return Optional.of(cookie);
    }
    public static Optional<Cookie> DeleteCookie (HttpServletRequest request, HttpServletResponse response, String name) {
        Cookie [] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    cookie.setValue("");
                    cookie.setPath("/");
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
        }
        return Optional.empty();
    }
    // Serialize and Deserialize
    public static String serialize(Object object) {
        return Base64.getUrlEncoder()
                .encodeToString(SerializationUtils.serialize(object));
    }

    public static <T> T deserialize(Cookie cookie, Class<T> cls) {
        return cls.cast(SerializationUtils.deserialize(
                Base64.getUrlDecoder().decode(cookie.getValue())));
    }

}
