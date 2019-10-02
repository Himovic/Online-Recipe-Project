package com.sfg.springboot.recipeapp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.sfg.springboot.recipeapp.Service.RecipeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IndexController {
	
	private RecipeService recipeService;
	
	public IndexController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}
	
	@RequestMapping({"","/","/index"})
	public String getIndexPage(Model model) {
		log.debug("getIndexPage method in the IndexController");
		model.addAttribute("recipes",recipeService.listRecipe());
		
		return "index";
	}
}
