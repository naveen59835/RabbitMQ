/*
 * Author : Naveen Kumar
 * Date : 10-02-2023
 * Created With : IntelliJ IDEA Community Edition
 */

package com.niit.userproductservice.JwtFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

public class Jwt extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;
        String headers=request.getHeader("authorization");
        if(headers==null||!headers.startsWith("Bearer")){
            throw new ServletException("Missing Token");

        }else{
            String token=headers.substring(7);
            Claims claims= Jwts.parser().setSigningKey("hello").parseClaimsJws(token).getBody();
            System.out.println("claims: " + claims);
            filterChain.doFilter(request,response);

        }

    }

}
