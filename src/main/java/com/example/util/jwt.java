package com.example.util;

import io.jsonwebtoken.*;

import javax.sound.midi.SysexMessage;
import java.util.Date;
import java.util.UUID;


public class jwt {

    static long time = 1000*60*60*24;
    static String signature = "admin";


    public static String createToken(String mail, String username, String role){
        JwtBuilder jwtBuilder = Jwts.builder();

        String jwtToken = jwtBuilder
                //设置头部信息
                .setHeaderParam("typ","JWT")
                .setHeaderParam("alg", "HS256")
                //设置payload信息
                .claim("mail", mail)
                .claim("username", username)
                .claim("role", role)
                .setSubject("admin-test")
                .setExpiration(new Date(System.currentTimeMillis() + time))
                .setId(UUID.randomUUID().toString())
                //设置签名
                .signWith(SignatureAlgorithm.HS256, signature)
                .compact();
        System.out.println(jwtToken);
        return jwtToken;
    }

    public static boolean parseToken(String token){
        JwtParser jwtParser = Jwts.parser();
        Jws<Claims> claimsJws;

        try{
            claimsJws = jwtParser.setSigningKey(signature).parseClaimsJws(token);
        }catch (Exception ex){
            System.out.println("false");
            return false;
        }
        Claims claims = claimsJws.getBody();
        //解析用户名
        System.out.println(claims.get("username"));
        //解析id
        System.out.println(claims.get("role"));
//        //解析签名
//        System.out.println(claims.getSubject());
//        //解析token有效期
//        System.out.println(claims.getExpiration());

        return true;
    }
}
