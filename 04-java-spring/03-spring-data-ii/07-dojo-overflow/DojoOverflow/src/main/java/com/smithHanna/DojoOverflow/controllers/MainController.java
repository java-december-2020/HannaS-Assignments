package com.smithHanna.DojoOverflow.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.smithHanna.DojoOverflow.models.Answer;
import com.smithHanna.DojoOverflow.models.NewQuestion;
import com.smithHanna.DojoOverflow.models.Question;
import com.smithHanna.DojoOverflow.services.QuestionService;

@Controller
public class MainController {

	@Autowired
	private QuestionService qService; 
	
	@GetMapping("/questions")
	public String dashboard(Model model) {
		List<Question> allQuestions = this.qService.getAllQuestions();
		model.addAttribute("allQuestions", allQuestions);
		return "dashboard.jsp"; 
	}
	
	@GetMapping("/questions/new")
	public String newQuestion(@ModelAttribute("question")NewQuestion newQuestion) {
		return "newquestion.jsp"; 
	}
	
	@PostMapping("/questions")
	public String addNewQuestion(@Valid @ModelAttribute("question")NewQuestion newQuestion, BindingResult result) {
		if(result.hasErrors()) {
			return "newquestion.jsp"; 
		}
		this.qService.createQuestion(newQuestion);
		return "redirect:/questions"; 
	}
	
	@GetMapping("/questions/{id}")
	public String getQuestion(@PathVariable("id")Long id, @ModelAttribute("answers")Answer ans, Model model) {
		Question question = this.qService.getQuestionById(id);
		model.addAttribute("question", question);
		return "show.jsp"; 
	}
	@RequestMapping(value="/answers", method=RequestMethod.POST)
	public String addAnswer(@Valid @ModelAttribute("answers")Answer ans, BindingResult result) {
		if(result.hasErrors()) {
			return "show.jsp"; 
		}Answer newAnswer = this.qService.createAnswer(ans);
		return "redirect:/questions/" + newAnswer.getQuestion().getId();
	}
}
