package me.javaroad.message.code.controller;

import static me.javaroad.message.MessageConstants.API_PREFIX;

import me.javaroad.message.code.dto.request.SendCodeRequest;
import me.javaroad.message.exception.MessageError;
import me.javaroad.message.exception.MessageException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heyx
 */
@RestController
@RequestMapping(API_PREFIX + "/codes")
public class CodeController {

    @PostMapping
    public void sendCode(@RequestBody SendCodeRequest sendCodeRequest) {
        
        throw new MessageException(MessageError.INVALID_CODE);
    }
}
