package com.crm.application.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.application.authorization.JwtGenerator;
import com.crm.application.models.JwtUser;
import com.crm.application.models.TokenReponse;

//@CrossOrigin(origins = {"http://localhost:4200"})
//@CrossOrigin
@RestController
@RequestMapping("/token")
public class TokenController {
	 private JwtGenerator jwtGenerator;

	    public TokenController(JwtGenerator jwtGenerator) {
	        this.jwtGenerator = jwtGenerator;
	    }

	    @PostMapping
	    public TokenReponse generate(@RequestBody final JwtUser jwtUser) {

	        return jwtGenerator.generate(jwtUser);

	    }
	    
}
