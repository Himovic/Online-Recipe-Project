package com.sfg.springboot.recipeapp.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.sfg.springboot.recipeapp.Model.Notes;

public interface NotesRepository extends CrudRepository<Notes, Long> {

}
