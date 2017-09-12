package me.javaroad.data.entity.convert;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.persistence.AttributeConverter;
import org.apache.commons.lang3.StringUtils;

/**
 * @author heyx
 */
public class StringListConvert implements AttributeConverter<List<String>, String> {

    private static final String SEPARATOR = ",";

    @Override
    public String convertToDatabaseColumn(List<String> attribute) {
        return StringUtils.join(attribute, SEPARATOR);
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        String[] ids = dbData.split(SEPARATOR);
        return Arrays.stream(ids).filter(Objects::nonNull).collect(Collectors.toList());
    }

}
