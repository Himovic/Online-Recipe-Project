package com.sfg.springboot.recipeapp.Controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sfg.springboot.recipeapp.Model.Category;
import com.sfg.springboot.recipeapp.Model.UnitOfMesure;
import com.sfg.springboot.recipeapp.Repositories.CategoryRepository;
import com.sfg.springboot.recipeapp.Repositories.UnityOfMesureRepository;

@Controller
public class IndexController {
	
	private CategoryRepository categoryRepository;
	private UnityOfMesureRepository unitOfMesureRepository;
	
	public IndexController(CategoryRepository categoryRepository,UnityOfMesureRepository unitOfMesureRepository) {
		this.categoryRepository = categoryRepository;
		this.unitOfMesureRepository = unitOfMesureRepository;
	}
	
	@RequestMapping({"","/","/index"})
	public String getIndexPage() {
		Optional<Category> categoryOpt = categoryRepository.findByDescription("American");
		Optional<UnitOfMesure> UomOpt = unitOfMesureRepository.findByUom("Cup");
		
		System.out.println("American Category ID : "+categoryOpt.get().getId());
		System.out.println("Cup UOM ID : "+UomOpt.get().getId());
		return "index";
	}
}
