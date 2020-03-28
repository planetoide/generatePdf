package com.crm.application.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.crm.application.models.User;
import com.crm.application.services.IUserService;

@CrossOrigin(origins = {"http://localhost:4200"})
@Controller
@RequestMapping("/rest")
public class PdfController {
	@Autowired
	public IUserService userService;
	
	@GetMapping("/ver/{email}")
	public String ver(@PathVariable(value = "email") String email, Model model) {
		User user = userService.findByEmail(email);
		model.addAttribute("user", user);
		return "todo/ver";
	}
	
}
