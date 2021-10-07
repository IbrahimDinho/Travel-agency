package main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import main.model.User;
import main.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String getHome() {
//		System.out.println("Password admin:" + PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("admin"));
//		System.out.println("Password admin:" + PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("employee"));
//		System.out.println("Password admin:" + PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("client"));

		return "home";
	}
	
	// login page
	
	@GetMapping("/signup")
	public String signUp(Model model) {
		model.addAttribute("user", new User());
		return "form-signup";
		
	}
	
	@PostMapping("processSignup")
	public String processSignup(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
		
		boolean errors = false;
		if (user.getPassword().equals(user.getConfirmedPassword())) {
			redirectAttributes.addAttribute("differentPasswords", "Passwords are different");
			errors = true;
		}
		if (userService.loginExists(user.getLogin())) {
			redirectAttributes.addAttribute("loginExists", "Login already exists");
			errors = true;
		}
		if (errors) {
			return "redirect:/signup";
		}
		userService.createNewAccount(user);
		return "login";
		
	}
	
	
	
}
