package com.filter;
 
import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.model.User;
import com.repository.UserRepository;
import com.service.security.TokenService;


public class AutenticationByTokenFilter extends OncePerRequestFilter{

	private TokenService tokenService;
	private UserRepository repository;
	
	public AutenticationByTokenFilter(TokenService tokenService,UserRepository repository) {
		this.tokenService= tokenService;
		this.repository = repository;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = getToken(request);
		
		boolean isValid = tokenService.isValidToken(token);
		
		if(isValid) {
			autenticate(token);
		}
		filterChain.doFilter(request, response);
	}
	
	private void autenticate(String token) {
		Long userId =  tokenService.getIdUsuario(token);
		User user = repository.findById(userId).get();
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
	}
	
private String getToken(HttpServletRequest request){
		
		String token = request.getHeader("Authorization");
		if(token == null|| token.isEmpty()) {
		 return null;
		}
		return token;
	}

}
