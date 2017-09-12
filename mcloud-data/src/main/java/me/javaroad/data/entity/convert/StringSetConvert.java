package me.javaroad.data.entity.convert;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.AttributeConverter;
import org.apache.commons.lang3.StringUtils;

/**
 * @author heyx
 */
public class StringSetConvert implements AttributeConverter<Set<String>, String> {

    private static final String SEPARATOR = ",";

    @Override
    public String convertToDatabaseColumn(Set<String> attribute) {
        return StringUtils.join(attribute, SEPARATOR);
    }

    @Override
    public Set<String> convertToEntityAttribute(String dbData) {
        if (StringUtils.isBlank(dbData)) {
            return Collections.emptySet();
        }
        String[] ids = dbData.split(SEPARATOR);
        return Arrays.stream(ids).filter(Objects::nonNull).collect(Collectors.toSet());
    }

}
