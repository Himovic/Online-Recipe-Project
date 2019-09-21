package com.sfg.springboot.recipeapp.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity
public class Notes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private Recipe recipe;
	@Lob
	private String recipeNote;
	
	public Notes() {
		
	}
	
	public Notes(Recipe recipe, String recipeNote) {
		super();
		this.recipe = recipe;
		this.recipeNote = recipeNote;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Recipe getRecipe() {
		return recipe;
	}
	
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
	
	public String getRecipeNote() {
		return recipeNote;
	}
	
	public void setRecipeNote(String recipeNote) {
		this.recipeNote = recipeNote;
	}

	@Override
	public String toString() {
		return "Notes [recipe=" + recipe + ", recipeNote=" + recipeNote + "]";
	}
	
}
