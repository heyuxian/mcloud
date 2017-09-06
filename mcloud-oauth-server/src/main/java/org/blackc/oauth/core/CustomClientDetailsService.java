package org.blackc.oauth.core;

import java.util.Objects;
import org.blackc.oauth.core.mapper.ClientDetailMapper;
import org.blackc.oauth.security.entity.OAuthClient;
import org.blackc.oauth.security.service.OAuthClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Component;

/**
 * @author heyx
 */
@Component
public class CustomClientDetailsService implements ClientDetailsService {

    private final OAuthClientService clientService;
    private final ClientDetailMapper clientDetailMapper;

    @Autowired
    public CustomClientDetailsService(OAuthClientService clientService, ClientDetailMapper clientDetailMapper) {
        this.clientService = clientService;
        this.clientDetailMapper = clientDetailMapper;
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        OAuthClient client = clientService.getClientByClientId(clientId);
        if (Objects.isNull(client)) {
            throw new ClientRegistrationException("client[clientId=" + clientId + "] not found");
        }
        return clientDetailMapper.mapClientToDetails(client);
    }
}
