package me.javaroad.oauth.entity.convert;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.AttributeConverter;
import me.javaroad.oauth.entity.GrantType;

/**
 * @author heyx
 */

public class GrantTypeStringConvert implements AttributeConverter<Set<GrantType>, String> {

    private static final String SEPARATOR = ",";

    @Override
    public String convertToDatabaseColumn(Set<GrantType> attribute) {
        return Optional.ofNullable(attribute).orElse(Collections.emptySet()).stream().map(GrantType::name)
            .collect(Collectors.joining(SEPARATOR));
    }

    @Override
    public Set<GrantType> convertToEntityAttribute(String dbData) {
        return Arrays.stream(Optional.ofNullable(dbData).orElse("").split(SEPARATOR)).map(s -> {
            try {
                return GrantType.valueOf(s);
            } catch (Exception ignore) {
                return null;
            }
        }).filter(Objects::nonNull).collect(Collectors.toSet());
    }
}
