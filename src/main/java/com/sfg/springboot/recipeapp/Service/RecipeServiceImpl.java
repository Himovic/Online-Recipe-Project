package com.sfg.springboot.recipeapp.Service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.sfg.springboot.recipeapp.Model.Recipe;
import com.sfg.springboot.recipeapp.Repositories.RecipeRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j //Logger for Lombok
@Service
public class RecipeServiceImpl implements RecipeService {
	
	private RecipeRepository recipeRepository;
	
	public RecipeServiceImpl(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}
	
	@Override
	public Set<Recipe> listRecipe() {
		log.debug("I'm in the service layer");
		Set<Recipe> recipes = new HashSet<>();
		recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
		return recipes;
	}

}
