package com.tce.spring.oauth2.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class CorsFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		 	response.setHeader("Access-Control-Allow-Origin", "*");
		    response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
		    response.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type, Authorization");
		    response.setHeader("Access-Control-Max-Age", "3600");
		    if (!"OPTIONS".equals(request.getMethod())) {
		    	filterChain.doFilter(request, response);
		    } else {
		    }
	}

}