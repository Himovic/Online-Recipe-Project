package com.sfg.springboot.recipeapp.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.sfg.springboot.recipeapp.Model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
