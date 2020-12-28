package com.smithHanna.DojoSurvey.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SurveyController {
	
	@RequestMapping(value="/")
	public String index() {
		return "index.jsp"; 
	}
	@RequestMapping(value="/result", method=RequestMethod.POST)
	public String result(@RequestParam(value="name") String name, @RequestParam(value="locations") String location, @RequestParam(value="languages") String language, @RequestParam(value="comment") String comment, Model model) {
		model.addAttribute("name",name);
		model.addAttribute("locations",location);
		model.addAttribute("languages",language);
		model.addAttribute("comment",comment);
		return "result.jsp"; 
	}

}
