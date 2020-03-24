package com.crm.application.authorization;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crm.application.models.JwtUser;
import com.crm.application.models.User;
import com.crm.application.services.IUserService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtGenerator {
	@Autowired
	public IUserService userService;
	
	public String generate(JwtUser jwtUser) {
		User user1 = new User();
		user1 = userService.findByEmail(jwtUser.getUserName());
		if(user1 != null) {
			Claims claims = Jwts.claims()
	                .setSubject(jwtUser.getUserName());
	        claims.put("userId", String.valueOf(jwtUser.getId()));
	        claims.put("role", jwtUser.getRole());

	        return Jwts.builder()
	                .setClaims(claims)
	                .signWith(SignatureAlgorithm.HS512, "youtube")
	                .compact();
		} else {
			return "el usuario no esta registrado";
		}        
    }

}
