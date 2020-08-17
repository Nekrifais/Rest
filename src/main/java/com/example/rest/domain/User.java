package com.example.rest.domain;

import java.util.List;

import javax.persistence.*;

import io.swagger.annotations.ApiModelProperty;


@Entity
@Table(name = "user")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@ApiModelProperty(notes = "The database generated User ID")
    private Long id;
	
	@Column(name = "first_name")
	@ApiModelProperty(notes = "First name of user")
	private String firstName;
	
	@Column(name = "last_name")
	@ApiModelProperty(notes = "Last name of user")
	private String lastName;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Booking> bookings;
	
	public User() {
		
	}

	public User(Long id) {
		this.id = id;
	}

	public User(Long id, String firstName, String lastName, List<Booking> bookings) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.bookings = bookings;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
	
}
