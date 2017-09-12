package me.javaroad.oauth.security.controller.api;

import static me.javaroad.oauth.security.controller.OAuthConstants.API_PREFIX;

import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import me.javaroad.oauth.security.controller.api.request.OAuthClientRequest;
import me.javaroad.oauth.security.dto.ClientDto;
import me.javaroad.oauth.security.entity.OAuthClient;
import me.javaroad.oauth.security.mapper.OAuthMapper;
import me.javaroad.oauth.security.service.OAuthClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heyx
 */
@RestController
@RequestMapping(API_PREFIX + "/clients")
public class ClientController {

    private final OAuthClientService clientService;
    private final OAuthMapper mapper;

    @Autowired
    public ClientController(OAuthClientService clientService, OAuthMapper mapper) {
        this.clientService = clientService;
        this.mapper = mapper;
    }

    @ApiOperation(value = "创建client", httpMethod = "POST")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientDto createClient(@RequestBody @Valid OAuthClientRequest clientRequest) {
        OAuthClient client = clientService.createClient(clientRequest);
        return mapper.mapClientEntityToDto(client);
    }

    @ApiOperation(value = "修改client", httpMethod = "PUT")
    @PutMapping("{clientId}")
    public ClientDto modifyClient(@PathVariable Long clientId, @RequestBody @Valid ClientDto clientDto) {
        clientDto.setId(clientId);
        OAuthClient client = clientService.modifyClient(clientDto);
        return mapper.mapClientEntityToDto(client);
    }

    @ApiOperation(value = "获取client", httpMethod = "GET")
    @GetMapping("{clientId}")
    public ClientDto modifyClient(@PathVariable Long clientId) {
        OAuthClient client = clientService.getClient(clientId);
        return mapper.mapClientEntityToDto(client);
    }

    @ApiOperation(value = "删除client", httpMethod = "DELETE")
    @DeleteMapping("{clientId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClient(@PathVariable Long clientId) {
        clientService.deleteClient(clientId);
    }
}
