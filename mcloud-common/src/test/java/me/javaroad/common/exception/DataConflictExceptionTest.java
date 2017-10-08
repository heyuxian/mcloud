package me.javaroad.common.exception;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 * @author heyx
 */
public class DataConflictExceptionTest {

    @Test
    public void testParam() {
        DataConflictException dataConflictException = new DataConflictException("hello %s", "world");
        assertThat(dataConflictException.getMessage()).isEqualTo("hello world");
    }

}