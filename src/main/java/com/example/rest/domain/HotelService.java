package com.example.rest.domain;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.*;

import io.swagger.annotations.ApiModelProperty;


@Entity
@Table(name = "hotel_service")
public class HotelService {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "The database generated HotelService ID")
	@Column(name = "id")
    private Long id;
	
	@Column(name = "name", nullable = false)
	@ApiModelProperty(notes = "The name of HotelService")
	private String name;
	
	@Column(name = "price", nullable = false)
	@ApiModelProperty(notes = "The Price of HotelService")
	private BigDecimal price;
	
	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinTable(name = "booking_hotel_service",
				joinColumns = { @JoinColumn(name = "id_hotel_service") },
				inverseJoinColumns = { @JoinColumn(name = "id_booking") })
	@ApiModelProperty(notes = "List of HotelService")
	private List<Booking> bookings;
	
	public HotelService() {
		
	}
	
	public HotelService(Long id, String name, BigDecimal price, List<Booking> bookings) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.bookings = bookings;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}	

}
