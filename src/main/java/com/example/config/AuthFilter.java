//package com.example.config;
//
//import com.example.util.jwt;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//
//
//@WebFilter(filterName="filter02",urlPatterns={"*"})
//public class AuthFilter implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException{
//        HttpServletRequest request = (HttpServletRequest)servletRequest;
//        System.out.println(request.getRequestURL());
//        String requestURL = request.getRequestURL().toString();
//        if("http://localhost:8080/user/login".equals(requestURL) || "http://localhost:8080/user/register".equals(requestURL)){
//            filterChain.doFilter(servletRequest, servletResponse);
//
//        }else{
//            String token = request.getHeader("Authorization");
//            boolean b = jwt.parseToken(token);
//            if(b){
//                filterChain.doFilter(servletRequest, servletResponse);
//            }
//            else{
//                servletResponse.getWriter().println("403");
//            }
//        }
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
