package com.smithHanna.ControllersAndViews.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.smithHanna.ControllersAndViews.models.User;
import com.smithHanna.ControllersAndViews.services.UserService;

@Controller
public class Users {
	
	@Autowired
	private UserService uService; 
	
	@GetMapping("/registration")
	public String registerForm(@ModelAttribute("user")User user) {
		return "registrationPage.jsp"; 
	}
	
	@PostMapping("/registration")
	public String registerUser(@Valid @ModelAttribute("user")User user, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "registrationPage.jsp"; 
		}
		User newUser = this.uService.registerUser(user);
		session.setAttribute("userId", newUser.getId());
		return "redirect:/login"; 
	}
	
	@GetMapping("/login")
	public String login() {
			return "loginPage.jsp"; 
	}
	
	@PostMapping("/login")
	public String loginUser(@RequestParam("email") String email, @RequestParam("password")String password, RedirectAttributes redirectAttrs, HttpSession session) {
		boolean isAuthenticated =this.uService.authenticateuser(email, password);
		if(isAuthenticated) {
		User user = this.uService.findByEmail(email);
		session.setAttribute("userId", user.getId());
		return "redirect:/home"; 
	}else {
		return "redirect:/login"; 
		}
	}
	
	@RequestMapping("/home")
	public String home(HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("userId");
		User user = this.uService.findUserById(userId);
		model.addAttribute("user", user);
		return "homePage.jsp"; 
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login"; 
		
	}
}
