package com.hannaSmith.DisplayDate.DateController;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.time.LocalDate; 
import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter;

@Controller 
public class DisplayController {
	
	
	@GetMapping("/")
	public String index() {
		return "index.jsp"; 
	}
	@GetMapping("/date")
	public String date(Model model) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, 'the' dd 'of' MMMM, YYYY");
		String dateToday = LocalDate.now().format(formatter);
		model.addAttribute("now", dateToday);
		return "date.jsp"; 
	}
	
	@GetMapping("/time")
	public String time(Model viewModel) {
		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("h:mm a");
		String timeNow = LocalDateTime.now().format(timeFormat);
		viewModel.addAttribute("rightNow", timeNow);
		return "time.jsp";
	}

}
