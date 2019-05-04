package com.zzping.common;

import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.DefaultJwtBuilder;
import io.jsonwebtoken.impl.DefaultJwtParser;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
public class JwtCreator {
    private String id;
    private String userName;

    public String create(){
        JwtBuilder builder = new DefaultJwtBuilder();
        String compact = builder.setId(id).setSubject(userName).setIssuedAt(new Date()).claim("role","amdin")
                .signWith(SignatureAlgorithm.HS256, "zzp1234").compact();
    return compact;
    }
   /* public static void main(String[] args) {
        JwtBuilder builder = new DefaultJwtBuilder();
        String compact = builder.setId("123").setSubject("植智平").setIssuedAt(new Date()).claim("role","amdin")
                .signWith(SignatureAlgorithm.HS256, "zzp1234").compact();
        System.out.println(compact);
        JwtParser parser = new DefaultJwtParser();
        Jwt jwt = parser.setSigningKey("zzp1234").parse(compact);
        Object body = jwt.getBody();
        if (body instanceof Claims){
            Claims claims = (Claims) body;
            String subject = claims.getSubject();
            System.out.println("解密后的用户名："+subject);
            System.out.println("角色"+claims.get("role"));
        }
    }*/

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
