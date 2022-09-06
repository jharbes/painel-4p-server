package com.controller;

import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controller.dto.security.TokenDTO;
import com.controller.dto.security.UserDTO;
import com.model.User;
import com.service.security.TokenService;


@RestController
@RequestMapping(value = "/login")
public class LoginController {

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private TokenService tokenService;
	
	@Autowired
	ModelMapper modelMapper;
	
	@PostMapping
	public ResponseEntity login(@RequestBody User user) {
		UsernamePasswordAuthenticationToken dadosLogin = convert(user);

		try {
			Authentication authentication = authManager.authenticate(dadosLogin);
			Map<String, Object> user_token = tokenService.generateToken(authentication);
			return ResponseEntity.ok().body(new TokenDTO((String) user_token.get("token")
					,"Bearer"
					, new UserDTO().convertToDTO((User)user_token.get("user"), modelMapper)));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	public UsernamePasswordAuthenticationToken convert(User user) {
		return new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
	}
}
