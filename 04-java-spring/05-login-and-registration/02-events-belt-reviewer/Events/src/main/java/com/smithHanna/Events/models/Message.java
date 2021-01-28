package com.smithHanna.Events.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity 
@Table(name="message")
public class Message {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id; 
@NotBlank
private String content; 
@Column(updatable=false)
private Date createdAt; 
private Date updatedAt; 
@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="user_id")
private User user; 
@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="event_id")
private Event event; 

public Message() {
	
}

public Message(User author, Event event, String content) {
	this.user = author; 
	this.event = event; 
	this.content = content; 
}

public String getContent() {
	return content;
}

public void setContent(String content) {
	this.content = content;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
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

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public Event getEvent() {
	return event;
}

public void setEvent(Event event) {
	this.event = event;
}

@PrePersist
protected void onCreate() {
	this.createdAt = new Date();
}

@PreUpdate
protected void onUpdate() {
	this.updatedAt = new Date();
}


}
