package com.sfg.springboot.recipeapp.Controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sfg.springboot.recipeapp.Model.Category;
import com.sfg.springboot.recipeapp.Model.UnitOfMesure;
import com.sfg.springboot.recipeapp.Repositories.CategoryRepository;
import com.sfg.springboot.recipeapp.Repositories.UnityOfMesureRepository;
import com.sfg.springboot.recipeapp.Service.RecipeService;

@Controller
public class IndexController {
	
	private RecipeService recipeService;
	
	public IndexController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}
	
	@RequestMapping({"","/","/index"})
	public String getIndexPage(Model model) {
		
		model.addAttribute("recipes",recipeService.listRecipe());
		
		return "index";
	}
}
