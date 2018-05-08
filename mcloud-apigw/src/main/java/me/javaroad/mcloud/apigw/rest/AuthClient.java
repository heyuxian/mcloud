package me.javaroad.mcloud.apigw.rest;

import feign.Headers;
import me.javaroad.mcloud.apigw.dto.AuthDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author heyx
 */
@FeignClient(name = "auth", url = "http://localhost:8443/auth/realms/mcloud/protocol/openid-connect/token")
public interface AuthClient {

    @PostMapping
    @Headers("Content-Type: application/x-www-form-urlencoded")
    AuthDto login(MultiValueMap<String, String> param);
}
