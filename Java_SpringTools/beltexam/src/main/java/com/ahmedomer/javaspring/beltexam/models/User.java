package com.ahmedomer.javaspring.beltexam.models;

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
import javax.persistence.OneToMany;
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
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message="First Name cannot be Blank!")
	@Size(min=2, max=25, message="First name must be longer than 2 characters")
	private String firstName;
	
	@NotBlank(message="Last Name cannot be Blank")
	@Size(min=2, max=33, message="Last name must be longer than 2 characters")
	private String lastName;
	
	@NotBlank(message="Email must be provided")
	@Pattern(regexp="^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+.[a-zA-Z0-9.-]+$", message="Invalid email pattern")
	@Email(message="Email must be valid")
	private String email;
	
	@NotBlank(message="Must provide password")
	@Size(min=8, message="Must be at least 8 characters long")
	private String password;
	
	@Transient
	@NotBlank(message="Please confirm password")
	private String confirmPassword;
	
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	////AREA LEFT FOR JOINS(MANY TO MANY, ONE TO MANY, ONE TO ONE)\\\\\
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	private List <Idea> ideas;
	public User () {
		
	}
	public User(long id, String firstName, String lastName, String password, String confirmPassword) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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
	public List<Idea> getIdeas() {
		return ideas;
	}
	public void setIdeas(List<Idea> ideas) {
		this.ideas = ideas;
	}

}
