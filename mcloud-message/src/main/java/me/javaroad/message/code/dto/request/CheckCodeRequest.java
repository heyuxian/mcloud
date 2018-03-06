package me.javaroad.message.code.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import me.javaroad.message.code.entity.CodeType;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author heyx
 */
public class CheckCodeRequest {
    @NotEmpty
    @Size(min = 6, max = 50)
    private String username;
    @NotEmpty
    private String to;
    @NotEmpty
    private String code;
    @NotNull
    private CodeType type;
}
