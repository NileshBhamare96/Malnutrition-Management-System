package com.app.pojos;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_meals")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserMeals {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 30)
	private String name;
	private int calorie;
	@Column(name = "entry_date")
	private LocalDate entryDate = LocalDate.now();
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	public UserMeals() {
		// TODO Auto-generated constructor stub
	}
	public UserMeals(String name, int calorie) {
		super();
		this.name = name;
		this.calorie = calorie;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCalorie() {
		return calorie;
	}
	public void setCalorie(int calorie) {
		this.calorie = calorie;
	}
	public LocalDate getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(LocalDate entryDate) {
		this.entryDate = entryDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "UserMeals [id=" + id + ", name=" + name + ", calorie=" + calorie + ", entryDate=" + entryDate
				+ ", user=" + user + "]";
	}
}
