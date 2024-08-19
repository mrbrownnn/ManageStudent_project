package com.fpt.booking.services.impl;

import com.fpt.booking.secruity.UserPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;

public abstract class BaseService {
    public Long getUserId(){
        UserPrincipal user = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        return user.getId();
    }
}
