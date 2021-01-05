package com.smithHanna.Languages.Models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity 
@Table(name="Languages")
public class Language {
	
@Id 
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long Id; 
@Size(min=2, max=20)
private String name;
@Size(min=2, max=20)
private String creator;
@NotBlank 
private String version; 
@Column(updatable=false)
@DateTimeFormat(pattern="yyy-MM-DD HH:mm:ss")
private Date createdAt; 
@DateTimeFormat(pattern="yyy-MM-DD HH:mm:ss")
private Date updatedAt;

@PrePersist
protected void onCreate() {
	this.createdAt = new Date();
}

@PreUpdate
protected void onUpdate() {
	this.updatedAt = new Date();
}

public Language(String creator, String name, String version) {
	this.creator = creator; 
	this.name = name; 
	this.version = version; 
	
}

public Language() {
	
}

public Long getId() {
	return Id;
}

public void setId(Long id) {
	Id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getCreator() {
	return creator;
}

public void setCreator(String creator) {
	this.creator = creator;
}

public String getVersion() {
	return version;
}

public void setVersion(String version) {
	this.version = version;
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



}
