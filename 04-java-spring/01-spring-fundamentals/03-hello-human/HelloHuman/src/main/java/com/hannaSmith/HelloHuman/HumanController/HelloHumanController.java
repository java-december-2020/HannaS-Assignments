package com.hannaSmith.HelloHuman.HumanController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller 
public class HelloHumanController {

	@GetMapping("/")
	public String index(@RequestParam(value="name", required=false, defaultValue="Human") String name, @RequestParam(value="last_name", required=false, defaultValue="") String lastName,  Model model) {
		model.addAttribute("name", name);
		model.addAttribute("last_name", lastName);
		return "index.jsp"; 
	}
	
}
