package com.smithHanna.DojoOverflow.models;

import javax.validation.constraints.NotBlank;

public class NewQuestion {
@NotBlank
private String question; 
@NotBlank
private String tags; 

public NewQuestion() {
	
}

public String[] splitTags() {
	return this.tags.split(", ");
}

public String getQuestion() {
	return question;
}

public void setQuestion(String question) {
	this.question = question;
}

public String getTags() {
	return tags;
}

public void setTags(String tags) {
	this.tags = tags;
}


}
