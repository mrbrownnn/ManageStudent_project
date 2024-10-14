package com.fpt.manage.Springboot_Manage_app.config;
import lombok.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@ConfigurationProperties(prefix="app")
@Getter
@Component

public class AppProperties {
    private final Auth auth = new Auth();

    @Getter
    public static class Auth {
        private String tokenSecret;
        private long tokenExpirationMsec;
        // private long tokenExpirationMsec = 864_000_000;

        public String getTokenSecret() {
            return tokenSecret;
        }

        public void setTokenSecret(String tokenSecret) {
            this.tokenSecret = tokenSecret;
        }

        public long getTokenExpirationMsec() {
            return tokenExpirationMsec;
        }

        public void setTokenExpirationMsec(long tokenExpirationMsec) {
            this.tokenExpirationMsec = tokenExpirationMsec;
        }
    }
    // remove oauth2

    public Auth getAuth() {
        return auth;
    }
}
