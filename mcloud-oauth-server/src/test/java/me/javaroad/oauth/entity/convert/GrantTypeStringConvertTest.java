package me.javaroad.oauth.entity.convert;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.collect.Sets;
import java.util.Set;
import me.javaroad.oauth.entity.GrantType;
import org.junit.Test;

/**
 * @author heyx
 */
public class GrantTypeStringConvertTest {

    private GrantTypeStringConvert convert = new GrantTypeStringConvert();

    @Test
    public void convertToDatabaseColumn() throws Exception {
        Set<GrantType> grantTypes = Sets.newHashSet(
            GrantType.values()
        );
        String result = convert.convertToDatabaseColumn(grantTypes);
        assertThat(result).isNotBlank();
    }

    @Test
    public void convertToEntityAttribute() throws Exception {
        String dbData = "CODE";
        Set<GrantType> grantTypes = convert.convertToEntityAttribute(dbData);
        assertThat(grantTypes.contains(GrantType.CODE));
    }

    @Test
    public void convertToEntityAttribute_invalidData_shouldReturnEmptySet() throws Exception {
        String dbData = "invalidData";
        Set<GrantType> grantTypes = convert.convertToEntityAttribute(dbData);
        assertThat(grantTypes).isEmpty();
    }

}