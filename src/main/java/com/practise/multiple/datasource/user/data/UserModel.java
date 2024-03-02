package com.practise.multiple.datasource.user.data;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class UserModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(unique = true, nullable = false)
	@NotEmpty(message = "userName can not be empty")
    @NotBlank(message = "userName can not be blank")
    @NotNull(message = "userName can not be null")
    @Size(min = 10, max = 100, message = "userName must be between 10 and 100 characters long")
	private String userName;

	@Column(unique = true, nullable = false)
	@NotEmpty(message = "email can not be empty")
    @NotBlank(message = "email can not be blank")
    @NotNull(message = "email can not be null")
    @Size(min = 10, max = 100, message = "email must be between 10 and 100 characters long")
	private String email;

	@Column(nullable = false)
    @NotEmpty(message = "firstName can not be empty")
    @NotBlank(message = "firstName can not be blank")
    @NotNull(message = "firstName can not be null")
    @Size(min = 10, max = 100, message = "firstName must be between 10 and 100 characters long")
	private String firstName;

	@Column(nullable = false)
	@NotEmpty(message = "lastName can not be empty")
    @NotBlank(message = "lastName can not be blank")
    @NotNull(message = "lastName can not be null")
    @Size(min = 10, max = 100, message = "lastName must be between 10 and 100 characters long")
	private String lastName;

	@Column(nullable = false)
	@NotEmpty(message = "password can not be empty")
    @NotBlank(message = "password can not be blank")
    @NotNull(message = "password can not be null")
    @Size(min = 10, max = 100, message = "password must be between 10 and 100 characters long")
	private String password;

	@Column(updatable = false)
	@CreationTimestamp
	private LocalDateTime joinedAt;

	@Column(updatable = false)
	@UpdateTimestamp
	private LocalDateTime updatedAt;

	protected UserModel() {
	}

	public UserModel(String userName, String email, String firstName, String lastName, String password,
			LocalDateTime joinedAt, LocalDateTime updatedAt) {
		this.userName = userName;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.joinedAt = joinedAt;
		this.updatedAt = updatedAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getJoinedAt() {
		return joinedAt;
	}

	public void setJoinedAt(LocalDateTime joinedAt) {
		this.joinedAt = joinedAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return String.format(
				"Customer[id=%d, userName='%s', email='%s', firstName='%s', lastName='%s', password='%s',"
						+ "joinedAt='%s', updatedAt='%s']",
				id, userName, email, firstName, lastName, password, joinedAt, updatedAt);
	}
}