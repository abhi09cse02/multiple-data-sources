package com.practise.multiple.datasource.customer.data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class CustomerModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
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

	protected CustomerModel() {
	}

	public CustomerModel(String email, String firstName, String lastName) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return String.format("Customer[id=%d, firstName='%s', lastName='%s',email='%s']", id, firstName, lastName,
				email);
	}

	public Integer getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
}