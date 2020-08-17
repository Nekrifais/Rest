package com.example.rest.domain;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.*;

import io.swagger.annotations.ApiModelProperty;



@Entity
@Table(name = "room")
public class Room {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "The database generated Room ID")
	@Column(name = "id")
    private Long id;
	
	@Column(name = "number", nullable = false)
	@ApiModelProperty(notes = "Special number of room")
	private String number;
	
	@ApiModelProperty(notes = "Price of room")
	@Column(name = "price", nullable = false)
	private BigDecimal price;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_room_category", nullable = false)
	@ApiModelProperty(notes = "Category of room")
	private RoomCategory roomCategory;
	
	@OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
	private List<Booking> bookings;
	
	public Room() {
		
	}
	
	public Room(Long id, String number, BigDecimal price, RoomCategory roomCategory, List<Booking> bookings) {
		this.id = id;
		this.number = number;
		this.price = price;
		this.roomCategory = roomCategory;
		this.bookings = bookings;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public RoomCategory getRoomCategory() {
		return roomCategory;
	}

	public void setRoomCategory(RoomCategory roomCategory) {
		this.roomCategory = roomCategory;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

}
