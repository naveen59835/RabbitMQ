/*
 * Author : Naveen Kumar
 * Date : 10-02-2023
 * Created With : IntelliJ IDEA Community Edition
 */

package com.niit.userauthservice.service;

import com.niit.userauthservice.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Service
public class SecurityTokenGeneratorImpl implements SecurityTokenGenerator {
    @Override
    public Map<String, String> generateToken(User user){
        Map<String, String> tokenmap=new HashMap<String,String>();
        user.setPassword("");
        Map<String,Object> userData=new HashMap<>();
        userData.put("userId",user.getUserId());
        String jwt = Jwts.builder().setClaims(userData).setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS512,"hello").compact();
        tokenmap.put("token",jwt);
        tokenmap.put("message","Login Successful");
        return tokenmap;
    }


}
