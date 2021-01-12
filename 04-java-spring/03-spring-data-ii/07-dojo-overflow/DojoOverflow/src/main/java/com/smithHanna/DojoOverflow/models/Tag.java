package com.smithHanna.DojoOverflow.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="tags")
public class Tag {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id; 
@NotBlank
private String subject; 
@DateTimeFormat(pattern="yyy-MM-DD HH:mm:ss")
private Date createdAt; 
@DateTimeFormat(pattern="yyy-MM-DD HH:mm:ss")
private Date updatedAt; 


@ManyToMany(fetch=FetchType.LAZY)
@JoinTable(name = " tags_questions",
joinColumns = @JoinColumn(name = "tags_id"),
inverseJoinColumns = @JoinColumn(name = "questions_id"))

private List<Question> questions;

public Tag() {
	
}

public Tag(String subject) {
	this.subject = subject; 
	
}

@PrePersist
protected void onCreate() {
	this.createdAt = new Date();
}

@PreUpdate
protected void onUpdate() {
	this.updatedAt = new Date();
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getSubject() {
	return subject;
}

public void setSubject(String subject) {
	this.subject = subject;
}

public Date getCreatedAt() {
	return createdAt;
}

public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}

public Date getUpdatedAt() {
	return updatedAt;
}

public void setUpdatedAt(Date updatedAt) {
	this.updatedAt = updatedAt;
}

public List<Question> getQuestions() {
	return questions;
}

public void setQuestions(List<Question> questions) {
	this.questions = questions;
}


}
