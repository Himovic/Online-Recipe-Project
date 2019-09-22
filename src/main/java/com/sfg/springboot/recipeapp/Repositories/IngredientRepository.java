package com.sfg.springboot.recipeapp.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.sfg.springboot.recipeapp.Model.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient,Long> {

}
