package com.ahmedomer.javaspring.javaproject.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.JoinColumn;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="messages")
public class Message {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
//	@NotBlank(message="Composer cannot be blank")
//	private String composer;
	
//	@NotBlank(message="A message needs to be composed")
	@Size(min=7, message="Must be at least 7 characters")
	private String message;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	@PrePersist
	protected void onCreate() {
		this.createdAt= new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt= new Date();
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="event_id")
	private Event event;
	
	public Message() {
		
	}
	public Message(long id, User user, String message, Event event) {
		this.id = id;
		this.user = user;
		this.message = message;
		this.event = event;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
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
	
	
}
