package com.hannaSmith.Counter.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {

	@RequestMapping("/")
	public String index(HttpSession session, Model model) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		Integer hitCounter = (Integer)session.getAttribute("count");
		hitCounter++;
		session.setAttribute("count", hitCounter);
		model.addAttribute("count", session.getAttribute("count"));
		return "index.jsp"; 
	}
	@RequestMapping("/counter")
	public String counter(HttpSession session) {
		return "counter.jsp"; 
				
	}
	@RequestMapping("/reset")
	public String sesh(HttpSession session) {
		session.setAttribute("count", 0);
		return "redirect:/counter"; 
	}

}

	