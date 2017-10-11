package me.javaroad.oauth.core;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import me.javaroad.oauth.entity.User;
import me.javaroad.oauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * @author heyx
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.get(username);
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException(String.format("User[username=%s] not found", username));
        }
        if (CollectionUtils.isEmpty(user.getAuthorities())) {
            return null;
        }
        Set<GrantedAuthority> grantedAuthorities = user.getAuthorities().stream().map(authority ->
            new SimpleGrantedAuthority(authority.getName())
        ).collect(Collectors.toSet());
        return new SecurityUser(user.getUsername(), user.getPassword(), grantedAuthorities);
    }

}
