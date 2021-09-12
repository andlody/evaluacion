package com.andree.evaluacion.services;

import com.andree.evaluacion.configuration.Config;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.DefaultJwtSignatureValidator;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class JWTService {
    public static String createJWT(int id,String name, String email) {
        Claims claims = Jwts.claims().setSubject("Token de acceso");
        claims.put("Id",  id);
        claims.put("name", name);
        claims.put("user", email);

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, Base64.getEncoder().encodeToString(Config.JWTSecret.getBytes()) )
                .compact();
    }

    public static boolean validateToken(String token){
        String[] tk = token.split("\\.");
        if(tk.length<3) return false;
        SecretKeySpec secretKeySpec = new SecretKeySpec(Config.JWTSecret.getBytes(), SignatureAlgorithm.HS512.getJcaName());
        DefaultJwtSignatureValidator validator = new DefaultJwtSignatureValidator(SignatureAlgorithm.HS512, secretKeySpec);

        return (validator.isValid(tk[0]+"."+tk[1],tk[2]))? true : false;
    }
}
