package com.fpt.booking.secruity;





import com.fpt.booking.config.ResourceBundleConfig;
import com.fpt.booking.domain.entities.User;
import com.fpt.booking.exception.BadRequestException;
import com.fpt.booking.exception.ResourceNotFoundException;
import com.fpt.booking.repository.UserRepository;
import com.fpt.booking.utils.MessageUtils;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ResourceBundleConfig resourceBundleConfig;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String phone)
            throws UsernameNotFoundException {
        User user = userRepository.findByPhone(phone)
                .orElseThrow(() ->
                        new UsernameNotFoundException(this.resourceBundleConfig.getViMessage(MessageUtils.PHONE_DONT_EXISTS, phone))
                );
        if (Boolean.TRUE.equals(user.getIsLocked()))
        {
            throw new BadRequestException(this.resourceBundleConfig.getViMessage(MessageUtils.ACCOUNT_BLOCKED));
        }
        if (Boolean.FALSE.equals(user.getIsActive())) {
            throw new BadRequestException(this.resourceBundleConfig.getViMessage(MessageUtils.ACCOUNT_NOT_ACTIVE));
        }

        return UserPrincipal.create(user);
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new BadRequestException(this.resourceBundleConfig.getViMessage(MessageUtils.ACCOUNT_NOT_FOUND, id))
        );

        return UserPrincipal.create(user);
    }
}