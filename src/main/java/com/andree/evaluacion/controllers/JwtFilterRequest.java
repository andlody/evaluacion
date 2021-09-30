package com.andree.evaluacion.controllers;

import com.andree.evaluacion.domain.ErrorResponse;
import com.andree.evaluacion.utils.JWTUtils;
import com.andree.evaluacion.utils.Messages;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class JwtFilterRequest extends OncePerRequestFilter {

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Map<String,String> map = Collections.list(request.getHeaderNames())
                                            .stream().collect(Collectors.toMap(h -> h, request::getHeader));

        if(JWTUtils.validateToken(map.get("token")))
            filterChain.doFilter(request,response);
        else{
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            ObjectMapper mapper = new ObjectMapper();
            response.getWriter()
                    .write(mapper.writeValueAsString(
                            new ErrorResponse(Messages.ErrorJwtToken)
                    ));
        }
    }
}
