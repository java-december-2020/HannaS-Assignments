package com.smithHanna.Events.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank; 

@Entity 
@Table(name="users")
public class User {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; 
	@NotBlank
	private String firstName; 
	@NotBlank
	private String lastName; 
	@NotBlank
	private String city; 
	@NotBlank
	private String state; 
	@Email
	private String email; 
	@NotBlank
	private String password; 
	@Transient
	@NotBlank
	private String confirmPassword; 
	@Column(updatable=false)
	private Date createdAt; 
	private Date updatedAt; 
	@OneToMany(fetch=FetchType.LAZY, mappedBy="host", cascade=CascadeType.ALL)
	private List<Event> plannedEvents; 
	@OneToMany(fetch=FetchType.LAZY, mappedBy="user", cascade=CascadeType.ALL)
	private List<Message> messages; 
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
		name="users_events"	,
		joinColumns= @JoinColumn(name="user_id"),
		inverseJoinColumns= @JoinColumn(name="event_id"))
	private List<Event> eventsAttending; 
	
	public User() {
		
	}
	
	
	public List<Event> getPlannedEvents() {
		return plannedEvents;
	}


	public void setPlannedEvents(List<Event> plannedEvents) {
		this.plannedEvents = plannedEvents;
	}


	public List<Message> getMessages() {
		return messages;
	}


	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}


	public List<Event> getEventsAttending() {
		return eventsAttending;
	}


	public void setEventsAttending(List<Event> eventsAttending) {
		this.eventsAttending = eventsAttending;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String passwordConfirmation) {
		this.confirmPassword = passwordConfirmation;
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
	
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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
