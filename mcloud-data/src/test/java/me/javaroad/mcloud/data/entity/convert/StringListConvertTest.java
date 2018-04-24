package me.javaroad.mcloud.data.entity.convert;

import static org.assertj.core.api.Java6Assertions.assertThat;

import com.google.common.collect.Lists;
import java.util.List;
import org.junit.Test;

/**
 * @author heyx
 */
public class StringListConvertTest {

    private StringListConvert stringListConvert = new StringListConvert();

    @Test
    public void convertToDatabaseColumn() throws Exception {
        List<String> columns = Lists.newArrayList("a", "b", "c");
        String result = stringListConvert.convertToDatabaseColumn(columns);
        assertThat(result).isEqualTo("a,b,c");
    }

    @Test
    public void convertToEntityAttribute() throws Exception {
        String value = "a,b,c";
        List<String> columns = stringListConvert.convertToEntityAttribute(value);
        assertThat(columns.containsAll(Lists.newArrayList("a", "b", "c")));
    }

}