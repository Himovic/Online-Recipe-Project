package com.sfg.springboot.recipeapp.Service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.sfg.springboot.recipeapp.Model.Recipe;
import com.sfg.springboot.recipeapp.Repositories.RecipeRepository;

@Service
public class RecipeServiceImpl implements RecipeService {
	
	private RecipeRepository recipeRepository;
	
	public RecipeServiceImpl(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}
	
	@Override
	public Set<Recipe> listRecipe() {
		Set<Recipe> recipes = new HashSet<>();
		recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
		return recipes;
	}

}
