package com.barnnet.work.helper.util.token;

import com.barnnet.work.helper.entity.LoginUser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;

/**
 * @author barnnet
 * @date 2019/9/28
 */
public class TokenProducer {
    private static final Long TOKENTIME1 = 60L;
    private static final Long TOKENTIME2 = 61L;
    public static String tokenProduce(LoginUser loginUser){
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("role","admin");
        hashMap.put("id",loginUser.getId());
        hashMap.put("username",loginUser.getUserName());
        String token = Jwts.builder().setSubject(loginUser.getUserName())
                .setClaims(hashMap)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + TOKENTIME1*1000L))
                .setId(String.valueOf(loginUser.getId()))
                .signWith(SignatureAlgorithm.HS256, "SAUIBFWDFBHJ123")
                .compact();
        return token;
    }
    public static String refreshTokenProduce(LoginUser loginUser){
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("role","admin");
        String refreshToken = Jwts.builder().setSubject(loginUser.getUserName())
                .setClaims(hashMap)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + TOKENTIME2 * 1000L))
                .setId(String.valueOf(loginUser.getId()))
                .signWith(SignatureAlgorithm.HS256, "SAUIBFWDFBHJ123")
                .compact();
        return refreshToken;
    }
}
