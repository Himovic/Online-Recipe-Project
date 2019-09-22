package com.sfg.springboot.recipeapp.Bootstrap;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.sfg.springboot.recipeapp.Model.Category;
import com.sfg.springboot.recipeapp.Model.Difficulty;
import com.sfg.springboot.recipeapp.Model.Ingredient;
import com.sfg.springboot.recipeapp.Model.Notes;
import com.sfg.springboot.recipeapp.Model.Recipe;
import com.sfg.springboot.recipeapp.Model.UnitOfMesure;
import com.sfg.springboot.recipeapp.Repositories.CategoryRepository;
import com.sfg.springboot.recipeapp.Repositories.RecipeRepository;
import com.sfg.springboot.recipeapp.Repositories.UnityOfMesureRepository;

@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {
	
	private final RecipeRepository recipeRepository;
	private final UnityOfMesureRepository unityOfMesureRepository;
	private final CategoryRepository categoryRepository;
	
	public Bootstrap(RecipeRepository recipeRepository, UnityOfMesureRepository unityOfMesureRepository,
			CategoryRepository categoryRepository) {
		this.recipeRepository = recipeRepository;
		this.unityOfMesureRepository = unityOfMesureRepository;
		this.categoryRepository = categoryRepository;
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		recipeRepository.saveAll(SaveRecipe());
	}

	private Set<Recipe> SaveRecipe() {
		
		Set<Recipe> listRecipes = new HashSet<>();
		
		UnitOfMesure tableSpoon = unityOfMesureRepository.findByUom("Tablespoon").get();
		UnitOfMesure ounce = unityOfMesureRepository.findByUom("Ounce").get();
		UnitOfMesure flaky = unityOfMesureRepository.findByUom("Flaky").get();
		Category mexican = categoryRepository.findByDescription("Mexican").get();

		//First Recipe - First Ingredient
		Ingredient butter = new Ingredient();
		butter.setAmount(new BigDecimal(4));
		butter.setUom(tableSpoon);
		butter.setDescription("unsalted butter, melted");
		//First Recipe - Second Ingredient
		Ingredient potatoes = new Ingredient();
		potatoes.setAmount(new BigDecimal(6));
		potatoes.setUom(ounce);
		potatoes.setDescription("Yukon gold potatoes");
		//First Recipe - Third Ingredient
		Ingredient olive = new Ingredient();
		olive.setAmount(new BigDecimal(3));
		olive.setUom(tableSpoon);
		olive.setDescription("olive oil");
		//First Recipe - Fourth Ingredient
		Ingredient parsley = new Ingredient();
		parsley.setAmount(new BigDecimal(3));
		parsley.setUom(tableSpoon);
		parsley.setDescription("chopped fresh parsley, plus more for garnish");
		//First Recipe - Fifth Ingredient
		Ingredient seaSelt = new Ingredient();
		seaSelt.setAmount(new BigDecimal(1));
		seaSelt.setUom(flaky);
		seaSelt.setDescription("sea salt, to taste");
		//StringBuilder Note
		StringBuilder noteBuilder = new StringBuilder("1 Roast the potatoes: \n Preheat oven to 375°F. Toss the potatoes with "
				+ "3 tablespoons of olive oil and salt well. Arrange in one layer in a casserole "
				+ "pan or rimmed baking tray and roast until browned, about 50 minutes. \n");
		noteBuilder.append("2 Sauté onions and garlic: \n While the potatoes are roasting, make the "
				+ "sauce. Heat 2 tablespoons of olive oil in a medium pot set over medium-high heat. "
				+ "Sauté the chopped onions, stirring occasionally, for 4-5 minutes, or until they begin "
				+ "to brown on the edges. Add the garlic and sauté another 2 minutes. \n");
		noteBuilder.append("3 Make the sauce: \n Add the white wine to the pan and turn the heat to high. "
				+ "Boil on a high boil until the wine is reduced by half, then add the tomato paste and "
				+ "stir to combine. Add the crushed tomatoes, Tabasco sauce, salt, sugar and smoked "
				+ "paprika. Stir well and reduce the heat to a bare simmer. Let the sauce cook slowly "
				+ "while the potatoes roast. If you want, you can use a blender or an immersion blender "
				+ "to purée the sauce until smooth. \n");
		noteBuilder.append("4 Toss potatoes with sauce, continue to roast: \n When the potatoes are well "
				+ "browned, toss with the tomato sauce and return to the casserole pan. Continue to roast "
				+ "until the tomato sauce dries out a bit on the potatoes and caramelizes, about 10 "
				+ "minutes. \n");
		noteBuilder.append("Serve with the remaining tomato sauce as an appetizer or side dish. \n");
		String recipeStringNote = noteBuilder.toString();
		Notes recipeNote = new Notes();
		recipeNote.setRecipeNote(recipeStringNote);
		
		//Create First Recipe
		Recipe crispyPotatoes = new Recipe();
		crispyPotatoes.setDescription("Crispy Hasselback Potatoes! Vertical slices and an extra-long roast "
				+ "in the oven makes these potatoes both beautiful and delicious. So many crispy edges! "
				+ "Perfect holiday side dish.");
		crispyPotatoes.setCookTime(75);
		crispyPotatoes.setPrepTime(15);
		crispyPotatoes.setSource("SALLY VARGAS");
		crispyPotatoes.setUrl("https://www.simplyrecipes.com/recipes/crispy_hasselback_potatoes/");
		crispyPotatoes.setDifficulty(Difficulty.EASY);
		crispyPotatoes.setServing(1);
		//Relation Between Recipe and Notes
		crispyPotatoes.setNotes(recipeNote);
		//Relation Between Ingredient and Recipe
		crispyPotatoes.getIngredients().add(seaSelt);
		crispyPotatoes.getIngredients().add(parsley);
		crispyPotatoes.getIngredients().add(olive);
		crispyPotatoes.getIngredients().add(potatoes);
		crispyPotatoes.getIngredients().add(butter);
		seaSelt.setRecipe(crispyPotatoes);
		parsley.setRecipe(crispyPotatoes);
		olive.setRecipe(crispyPotatoes);
		potatoes.setRecipe(crispyPotatoes);
		butter.setRecipe(crispyPotatoes);
		//Relation between Recipe and Note
		crispyPotatoes.setNotes(recipeNote);
		recipeNote.setRecipe(crispyPotatoes);
		//Relation Between Category and Recipe
		crispyPotatoes.getCategories().add(mexican);
		
		System.out.println("Loaded first recipe...");
		listRecipes.add(crispyPotatoes);
		return listRecipes;
	}
}
