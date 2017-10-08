package me.javaroad.oauth.controller.web;

import javax.validation.Valid;
import me.javaroad.oauth.controller.web.request.ClientRequest;
import me.javaroad.oauth.controller.web.response.ClientResponse;
import me.javaroad.oauth.entity.Client;
import me.javaroad.oauth.mapper.ClientMapper;
import me.javaroad.oauth.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author heyx
 */
@Controller
@RequestMapping("client")
public class ClientController {

    private final ClientService clientService;
    private final ClientMapper clientMapper;

    @Autowired
    public ClientController(ClientService clientService, ClientMapper clientMapper) {
        this.clientService = clientService;
        this.clientMapper = clientMapper;
    }

    @GetMapping("create")
    public String create() {
        return "create";
    }

    @PostMapping("create")
    @ResponseBody
    public ClientResponse createClient(@Valid ClientRequest clientRequest) {
        Client client = clientService.createClient(clientRequest);
        return clientMapper.mapEntityToResponse(client);
    }

    @GetMapping("edit")
    public String edit() {
        return "edit";
    }

    @GetMapping("list")
    public String list() {
        return "list";
    }
}
