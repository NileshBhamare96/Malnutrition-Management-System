package com.app.pojos;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "contact")
public class Contact extends BaseEntity{
	private String name;
	private String address;
	private String message;
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	public Contact() {
		// TODO Auto-generated constructor stub
	}
	public Contact(String name, String address, String message) {
		super();
		this.name = name;
		this.address = address;
		this.message = message;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Contact [name=" + name + ", address=" + address + ", message=" + message + "]";
	}
	
}
