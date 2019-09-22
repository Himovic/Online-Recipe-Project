package com.sfg.springboot.recipeapp.Service;

import java.util.Set;

import com.sfg.springboot.recipeapp.Model.Recipe;

public interface RecipeService {
	
	public Set<Recipe> listRecipe();
}
