//package com.lawyer.customertrackingsystem.filter;
//
//import com.lawyer.customertrackingsystem.security.JwtService;
//import com.lawyer.customertrackingsystem.service.concrete.UserServiceImpl;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.Cookie;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//import org.springframework.web.servlet.HandlerExceptionResolver;
//
//import java.io.IOException;
//
//
//@Component
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//    private final JwtService jwtService;
//    private final UserServiceImpl userService;
//
//    public JwtAuthenticationFilter(JwtService jwtService, UserServiceImpl userService, UserServiceImpl userService1) {
//        this.jwtService = jwtService;
//
//        this.userService = userService1;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        String requestURI = request.getRequestURI();
//
//        // Skip JWT filter for login and public routes
//        if ("/login".equals(requestURI) || "/signup".equals(requestURI)) {
//            filterChain.doFilter(request, response);
//            return;
//        }
//
//        // Get JWT token from cookies
//        Cookie[] cookies = request.getCookies();
//        String jwtToken = null;
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                if ("jwt".equals(cookie.getName())) {
//                    jwtToken = cookie.getValue();
//                    break;
//                }
//            }
//        }
//
//        if (jwtToken != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//            String username = jwtService.extractUsername(jwtToken);
//
//            if (username != null) {
//                UserDetails userDetails = userService.loadUserByUsername(username);
//
//                // Validate the token
//                if (jwtService.isTokenValid(jwtToken, userDetails)) {
//                    UsernamePasswordAuthenticationToken authentication =
//                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                    SecurityContextHolder.getContext().setAuthentication(authentication);
//                }
//            }
//        }
//
//        filterChain.doFilter(request, response);
//    }
//
//
//
//
//}
