package com.service.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	public Map<String,Object> generateToken(Authentication authentication) {
		User logged = (User) authentication.getPrincipal();
		Date today = new Date();
		Date dateExpiration = new Date(today.getTime() + Long.parseLong("10000000000"));
		Map<String,Object> _return = new HashMap();
		Map<String,Object> claims = new HashMap<>();
        _return.put("token", Jwts.builder().setIssuer("token").setSubject(logged.getId().toString()).setIssuedAt(today)
				.setExpiration(dateExpiration).signWith(SignatureAlgorithm.HS256, "4pmkt").compact());
        _return.put("user",logged);

		
		 return _return;
	}
	
	public boolean isValidToken(String token) {
		try {
			Jwts.parser().setSigningKey("4pmkt").parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Long getIdUsuario(String token) {
		Claims body = Jwts.parser().setSigningKey("4pmkt").parseClaimsJws(token).getBody();
  		return Long.parseLong(body.getSubject());
	}

}
