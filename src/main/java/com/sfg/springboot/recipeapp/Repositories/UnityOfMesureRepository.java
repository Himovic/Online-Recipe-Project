package com.sfg.springboot.recipeapp.Repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sfg.springboot.recipeapp.Model.UnitOfMesure;

public interface UnityOfMesureRepository extends CrudRepository<UnitOfMesure, Long> {
	
	Optional<UnitOfMesure> findByUom(String uom);
}
