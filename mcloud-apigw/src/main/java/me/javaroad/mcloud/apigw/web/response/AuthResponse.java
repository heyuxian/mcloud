package me.javaroad.mcloud.apigw.web.response;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import me.javaroad.mcloud.apigw.dto.AuthDto;

public class AuthResponse extends AuthDto {

    @Getter
    @Setter
    private List<String> roles;
}
