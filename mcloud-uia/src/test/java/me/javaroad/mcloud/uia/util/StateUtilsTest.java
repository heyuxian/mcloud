package me.javaroad.mcloud.uia.util;

import static org.assertj.core.api.Assertions.assertThat;

import me.javaroad.mcloud.uia.entity.State;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

/**
 * @author heyx
 */
public class StateUtilsTest {

    @Test
    public void decode() throws Exception {
        State state = buildState();
        String encoded = StateUtils.encode(state);
        State decoded = StateUtils.decode(encoded);
        assertThat(decoded).isNotNull();
        assertThat(decoded.getNonce()).isEqualTo(state.getNonce());
        assertThat(decoded.getRedirectUri()).isEqualTo(state.getRedirectUri());
    }

    @Test
    public void encode() throws Exception {
        State state = buildState();
        String encoded = StateUtils.encode(state);
        assertThat(encoded).isNotBlank();
    }

    private State buildState() {
        State state = new State();
        state.setNonce(RandomStringUtils.randomAlphabetic(16));
        state.setRedirectUri("http://localhost");
        return state;
    }

}