package com.jperez.banking.configuration.security.jwt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Configuration
public class JwtConfiguration {

    @Bean
    public RSAPublicKey rsaPublicKey() {
        return (RSAPublicKey) generateKeyPair().getPublic();
    }

    @Bean
    public RSAPrivateKey rsaPrivateKey() {
        return (RSAPrivateKey) generateKeyPair().getPrivate();
    }

    private KeyPair generateKeyPair() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            return keyPairGenerator.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            // TODO Update a custom exception
            throw new RuntimeException(e);
        }
    }

}
