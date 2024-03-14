package com.app.pojos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	@Column(length = 30)
	private String name;
	@Column(unique = true, length = 30)
	private String email;
	@Column(length = 30)
	private String password;
	private int age;
	private int weight;
	private int height;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private double BMI;
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public User(Integer userId, String name, String email, String password, int age, int weight, int height,
			Gender gender) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.age = age;
		this.weight = weight;
		this.height = height;
		this.gender = gender;
	}
	public User(Integer userId, String name, String email, String password, int age, int weight, int height,
			Gender gender, double bMI) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.age = age;
		this.weight = weight;
		this.height = height;
		this.gender = gender;
		BMI = bMI;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public double getBMI() {
		return BMI;
	}
	public void setBMI(double bMI) {
		BMI = bMI;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password + ", age="
				+ age + ", weight=" + weight + ", height=" + height + ", gender=" + gender + ", BMI=" + BMI + "]";
	}
}
