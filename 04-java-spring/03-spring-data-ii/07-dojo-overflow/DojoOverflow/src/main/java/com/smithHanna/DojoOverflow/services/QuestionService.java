package com.smithHanna.DojoOverflow.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.smithHanna.DojoOverflow.models.Answer;
import com.smithHanna.DojoOverflow.models.NewQuestion;
import com.smithHanna.DojoOverflow.models.Question;
import com.smithHanna.DojoOverflow.models.Tag;
import com.smithHanna.DojoOverflow.repositories.AnswerRepository;
import com.smithHanna.DojoOverflow.repositories.QuestionRepository;
import com.smithHanna.DojoOverflow.repositories.TagRepository; 

@Service
public class QuestionService {

	private QuestionRepository qRepo; 
	private AnswerRepository aRepo; 
	private TagRepository tRepo; 
	
	public QuestionService(QuestionRepository QRepo, AnswerRepository ARepo, TagRepository TRepo) {
		this.qRepo =QRepo; 
		this.aRepo = ARepo;
		this.tRepo = TRepo; 
	}
	 
	
	public void createQuestion(NewQuestion question) {
		List<Tag> qTags = new ArrayList<Tag>();
		for(String subject: question.splitTags()) {
			Tag tag = this.tRepo.findBySubject(subject).orElse(null);
			if(tag == null) {
				tag = new Tag(subject);
				this.tRepo.save(tag);
			}
			if(!qTags.contains(tag))
				qTags.add(tag);
		}
		Question newQuestion = new Question(question.getQuestion(), qTags);
		this.qRepo.save(newQuestion);
	}
	
	public Question getQuestionById(Long id) {
		return this.qRepo.findById(id).orElse(null);
	}
	
	public List<Question> getAllQuestions(){
		return this.qRepo.findAll(); 
	}
	
	public Answer createAnswer(Answer answer) {
		return this.aRepo.save(answer);
	}
	

	
	
	
	
	
}
