package com.revature.app.services;

import com.revature.app.dtos.responses.Principal;
import com.revature.app.util.JwtConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;

import java.util.Date;

public class TokenService {

    private JwtConfig jwtConfig;

    public TokenService(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
    }

    public String generateToken(Principal subject) {

        long now = System.currentTimeMillis();

        JwtBuilder tokenBuilder = Jwts.builder()
                .setId(subject.getUserId())
                .setIssuer("app")
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + jwtConfig.getExpiration()))
                .setSubject(subject.getUsername())
                .claim("role", subject.getRole())
                .signWith(jwtConfig.getSigAlg(), jwtConfig.getSigningKey());

        return tokenBuilder.compact();

    }

    public Principal extractRequesterDetails(String token) {

        try {

            Claims claims = Jwts.parser()
                    .setSigningKey(jwtConfig.getSigningKey())
                    .parseClaimsJws(token)
                    .getBody();

            Principal principal = new Principal();
            principal.setUserId(claims.getId()); //??
            principal.setUsername(claims.getSubject());
            principal.setRole(claims.get("role", String.class));

            return principal;

        } catch (Exception e) {
            return null;
        }

    }

}
