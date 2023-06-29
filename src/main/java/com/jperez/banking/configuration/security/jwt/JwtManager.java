package com.jperez.banking.configuration.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.jperez.banking.adapters.driven.jpa.sqlserver.adapter.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Component
@RequiredArgsConstructor
public class JwtManager {

    private final RSAPublicKey rsaPublicKey;
    private final RSAPrivateKey rsaPrivateKey;

    public String createJwt(UserDetails userDetails) {
        Algorithm algorithm = Algorithm.RSA256(rsaPublicKey, rsaPrivateKey);
        return JWT.create()
                .withClaim("email", userDetails.getUsername())
                .withClaim("role", ((UserDetailsImpl) userDetails).getRole())
                .sign(algorithm);
    }

}
