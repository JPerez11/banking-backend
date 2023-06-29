package com.jperez.banking.configuration.security.jwt;

import com.jperez.banking.adapters.driven.jpa.postgres.adapter.UserDetailsImpl;
import com.jperez.banking.configuration.Constants;
import com.jperez.banking.configuration.security.exception.TokenException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collections;
import java.util.Date;

public class JwtToken {

    private static final String ROLE = "role";
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtToken.class);
    private static final String TOKEN_SECRET_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXvCJ9";
    private static final Long ACCESS_TOKEN_EXPIRATION_SECONDS = 3_600L;

    private JwtToken(){}

    public static String createJwt(@NonNull UserDetails userDetails) {
        long expirationTime = ACCESS_TOKEN_EXPIRATION_SECONDS * 1_000L;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

        String email = userDetails.getUsername();
        String role = ((UserDetailsImpl) userDetails).getRole();

        Claims claims = Jwts.claims().setSubject(email);
        claims.put(ROLE, role);

        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(expirationDate)
                .signWith(Keys.hmacShaKeyFor(TOKEN_SECRET_KEY.getBytes()))
                .compact();
    }

    public static UsernamePasswordAuthenticationToken getAuthenticationToken(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(TOKEN_SECRET_KEY.getBytes()))
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            String email = claims.getSubject();
            String role = claims.get(ROLE, String.class);
            GrantedAuthority authority = new SimpleGrantedAuthority(role);

            return new UsernamePasswordAuthenticationToken(
                    email,
                    null,
                    Collections.singletonList(authority)
            );
        } catch (JwtException e) {
            throw new TokenException();
        }
    }

    public static boolean verifyToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(TOKEN_SECRET_KEY.getBytes()))
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException e) {
            LOGGER.error(Constants.MALFORMED_TOKEN_MESSAGE);
        } catch (ExpiredJwtException e) {
            LOGGER.error(Constants.EXPIRED_TOKEN_MESSAGE);
        } catch (UnsupportedJwtException e) {
            LOGGER.error(Constants.UNSUPPORTED_TOKEN_MESSAGE);
        } catch (SignatureException e) {
            LOGGER.error(Constants.SIGNATURE_MESSAGE);
        } catch (IllegalArgumentException e) {
            LOGGER.error(Constants.ILLEGAL_ARGUMENT_MESSAGE);
        }
        return false;
    }


}
