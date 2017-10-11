package me.javaroad.oauth;

import java.security.KeyPair;
import java.util.Base64;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

/**
 * @author heyx
 */
public class KeyTest {

    @Test
    public void publicKey(){
        KeyPair keyPair = new KeyStoreKeyFactory(
            new ClassPathResource("keystore.jks"), "foobar".toCharArray())
            .getKeyPair("test");
        Base64.Encoder encoder = Base64.getEncoder();
        System.out.println(encoder.encodeToString(keyPair.getPublic().getEncoded()));
    }
}
