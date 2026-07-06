package org.example.hibye.security;
import io.jsonwebtoken.SignatureAlgorithm;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import java.util.Base64;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
final String SECRET = "thulakshana-jwt-secret-key-2026-123456789";

private final Key obj3=Keys.hmacShaKeyFor(SECRET.getBytes());

    private final Key Key =
            Keys.hmacShaKeyFor(
                    SECRET.getBytes());

    public String generateToken(
            String username) {

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(
                                System.currentTimeMillis()
                                        + 86400000))
                .signWith(
                        obj3,
                        SignatureAlgorithm.HS256)
                .compact();


}

public String extractusername(String token){
    return Jwts.parser().verifyWith((javax.crypto.SecretKey)obj3).build().parseEncryptedClaims(token).getPayload().getSubject();

}

public boolean validationtoken(String token) {
    try {
        Jwts.parser()
                .verifyWith((javax.crypto.SecretKey) obj3)
                .build()
                .parseSignedClaims(token);

        return true;

    } catch (Exception e) {
        return false;
    }

}
}
