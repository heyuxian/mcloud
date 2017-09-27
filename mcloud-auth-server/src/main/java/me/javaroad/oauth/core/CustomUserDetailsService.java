package me.javaroad.oauth.core;

import me.javaroad.oauth.security.service.OAuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author heyx
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private OAuthUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
