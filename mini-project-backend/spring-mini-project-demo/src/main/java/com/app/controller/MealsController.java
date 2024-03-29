package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Meals;
import com.app.service.IMealsService;

@RestController
@RequestMapping("/api/meals")
public class MealsController {
	@Autowired
	private IMealsService mealsService;
	
	@PostMapping
	public Meals addNewMeals(@RequestBody Meals meal) {
		System.out.println("in add new meal ");
		return mealsService.addNewMeal(meal);
	}
}
