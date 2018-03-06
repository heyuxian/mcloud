package me.javaroad.message.code.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import me.javaroad.message.code.entity.CodeType;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author heyx
 */
@Getter
@Setter
public class SendCodeRequest {
    @NotEmpty
    @Size(min = 6, max = 50)
    private String username;
    @NotNull
    private Long source;
    @NotEmpty
    private String to;
    @NotNull
    private CodeType type;
}
