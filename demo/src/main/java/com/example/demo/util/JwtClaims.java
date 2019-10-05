package com.example.demo.util;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

/**
 * @author barnnet
 * @date 2019/10/2
 */

public class JwtClaims {


    public static Jws<Claims> getJwsClaims(String token){
        JwtParser parser = Jwts.parser();
        parser.setSigningKey("SAUIBFWDFBHJ123");
        Jws<Claims> claimsJws = parser.parseClaimsJws(token);
        return claimsJws;
    }
    public static Claims getClaims(String token){
        Claims body = JwtClaims.getJwsClaims(token).getBody();
        return body;
    }
}
