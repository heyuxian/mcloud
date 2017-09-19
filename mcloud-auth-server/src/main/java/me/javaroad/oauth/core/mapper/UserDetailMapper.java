package me.javaroad.oauth.core.mapper;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import me.javaroad.oauth.security.entity.OAuthAuthority;
import me.javaroad.oauth.security.entity.OAuthUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * @author heyx
 */
@Mapper(componentModel = "spring")
public abstract class UserDetailMapper {

    public static UserDetailMapper INSTANCE = Mappers.getMapper(UserDetailMapper.class);

    public User mapUserToUserDetails(OAuthUser oauthUser) {
        User user = new User(oauthUser.getUsername(), oauthUser.getPassword(),
            mapAuthorityToGrantedAuthority(oauthUser.getAuthorities()));
        return user;
    }

    Set<GrantedAuthority> mapAuthorityToGrantedAuthority(Set<OAuthAuthority> authorities) {
        return Optional.ofNullable(authorities).orElse(Collections.emptySet()).stream().map(authority ->
            new SimpleGrantedAuthority(authority.getName())
        ).collect(Collectors.toSet());
    }
}
