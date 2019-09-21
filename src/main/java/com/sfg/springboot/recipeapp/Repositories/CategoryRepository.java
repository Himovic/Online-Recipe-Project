package com.sfg.springboot.recipeapp.Repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sfg.springboot.recipeapp.Model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	Optional<Category> findByDescription(String description);
}
