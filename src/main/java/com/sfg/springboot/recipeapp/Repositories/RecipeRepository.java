package com.sfg.springboot.recipeapp.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.sfg.springboot.recipeapp.Model.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
	
	
}
