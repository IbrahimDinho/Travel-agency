package main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import main.model.User;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String getHome() {
//		System.out.println("Password admin:" + PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("admin"));
//		System.out.println("Password admin:" + PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("employee"));
//		System.out.println("Password admin:" + PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("client"));

		return "home";
	}
	
	@GetMapping("/signup")
	public String signUp(Model model) {
		model.addAttribute("user", new User());
		return "form-signup";
		
	}
	
	
	
}
