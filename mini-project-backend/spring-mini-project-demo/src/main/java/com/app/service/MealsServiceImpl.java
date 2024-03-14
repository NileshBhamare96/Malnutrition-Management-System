package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.MealsRepository;
import com.app.pojos.Meals;

@Service
@Transactional
public class MealsServiceImpl implements IMealsService {
	@Autowired
	private MealsRepository mealRepo;
	
	@Override
	public Meals addNewMeal(Meals meal) {
		return mealRepo.save(meal);
	}

}
