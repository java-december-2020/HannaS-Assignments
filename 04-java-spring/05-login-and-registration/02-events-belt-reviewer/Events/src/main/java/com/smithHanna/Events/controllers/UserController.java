package com.smithHanna.Events.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.smithHanna.Events.Validators.UserValidator;
import com.smithHanna.Events.models.State;
import com.smithHanna.Events.models.User;
import com.smithHanna.Events.services.UserService; 

@Controller
public class UserController {
	@Autowired
	private UserService uService; 
	@Autowired
	private UserValidator uValidator; 
	
	
	@GetMapping("/")
	public String index(@ModelAttribute("user") User user, Model model) {
		model.addAttribute("states", State.States);
		return "registrationPage.jsp"; 
	}
	
	@PostMapping("/")
	public String registerUser(@Valid @ModelAttribute("user")User user, BindingResult result, HttpSession session, Model model) {
		uValidator.validate(user, result);
		if(result.hasErrors()) {
			model.addAttribute("states", State.States);
			return "registrationPage.jsp";
		}
		User newUser = this.uService.registerUser(user);
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/"; 
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("email1")String email, @RequestParam("password1")String password, RedirectAttributes rAttrs, HttpSession session) {
		if(!this.uService.authenticateUser(email, password)) {
			rAttrs.addFlashAttribute("loginError", "Invalid Credentials");
			return "redirect:/"; 
		}
		User user = this.uService.findUserByEmail(email);
		session.setAttribute("user_id", user.getId());
		return "redirect:/events"; 
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/"; 
	}
	
	
	
}

	


