package me.javaroad.oauth.core.mapper;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import me.javaroad.oauth.entity.Authority;
import me.javaroad.oauth.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 * @author heyx
 */
@Mapper(componentModel = "spring")
public abstract class UserDetailMapper {

    public static UserDetailMapper INSTANCE = Mappers.getMapper(UserDetailMapper.class);

    public org.springframework.security.core.userdetails.User mapUserToUserDetails(User oauthUser) {
        org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(oauthUser.getUsername(), oauthUser.getPassword(),
            mapAuthorityToGrantedAuthority(oauthUser.getAuthorities()));
        return user;
    }

    Set<GrantedAuthority> mapAuthorityToGrantedAuthority(Set<Authority> authorities) {
        return Optional.ofNullable(authorities).orElse(Collections.emptySet()).stream().map(authority ->
            new SimpleGrantedAuthority(authority.getName())
        ).collect(Collectors.toSet());
    }
}
