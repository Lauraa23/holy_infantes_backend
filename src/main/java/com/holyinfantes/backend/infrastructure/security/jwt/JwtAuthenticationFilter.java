package com.holyinfantes.backend.infrastructure.security.jwt;

import com.holyinfantes.backend.domain.user.User;
import com.holyinfantes.backend.infrastructure.security.service.CustomUserDetails;
import com.holyinfantes.backend.infrastructure.security.service.CustomUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            @NotNull HttpServletResponse response,
            @NotNull FilterChain filterChain
            ) throws ServletException, IOException {
        String token = getTokenFromRequest(request);
    try {
        if (token != null && tokenProvider.validateToken(token)) {
            String username = tokenProvider.getUsernameFromJwt(token);

            CustomUserDetails customUserDetails = (CustomUserDetails) customUserDetailsService
                    .loadUserByUsername(username);

            User user = customUserDetails.getUser();

            Long tokenIssuedAt = tokenProvider.getTokenIssuedAt(token);
            Long lastLogout = user.getLastLogout();

            if (lastLogout != null && tokenIssuedAt < lastLogout) {
                throw new RuntimeException("Token invalidated due to logout");
            }

            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(
                            customUserDetails,
                            null,
                            customUserDetails.getAuthorities());

            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
    } catch (Exception e) {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        response.getWriter().write("{\"error\": \"No logueado o token invalido\"}");
        return;
    }
        filterChain.doFilter(request, response);
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        if (token != null && token.startsWith("Bearer ")) {
            return token.substring(7);
        }

        return null;
    }
}
