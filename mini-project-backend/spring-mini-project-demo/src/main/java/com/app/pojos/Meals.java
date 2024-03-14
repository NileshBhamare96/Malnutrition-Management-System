package com.app.pojos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "meals")
public class Meals {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer mealId;
	@Column(length = 30)
	private String name;
	private int calorie;
	public Meals() {
		// TODO Auto-generated constructor stub
	}
	public Meals(String name, int calorie) {
		super();
		this.name = name;
		this.calorie = calorie;
	}
	public Integer getMealId() {
		return mealId;
	}
	public void setMealId(Integer mealId) {
		this.mealId = mealId;
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
	@Override
	public String toString() {
		return "Meals [mealId=" + mealId + ", name=" + name + ", calorie=" + calorie + "]";
	}
}
