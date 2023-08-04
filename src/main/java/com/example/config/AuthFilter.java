package com.example.config;

import com.example.util.jwt;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;


@WebFilter("/*")
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException{

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterchain) throws IOException, ServletException{
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        System.out.println(request.getRequestURL());
        String requestURI = request.getRequestURI();
        if("/user/login".equals(requestURI) || "/user/register".equals(requestURI)){
            filterChain.doFilter(servletRequest, servletResponse);

        }else{
            String token = request.getHeader("Authorization");
            boolean b = jwt.parseToken(token);
            if(b){
                filterChain.doFilter(servletRequest, servletResponse);
            }else{
                servletResponse.getWriter().println("403");
            }
        }
    }

    @Override
    public void destroy() {

    }
}
