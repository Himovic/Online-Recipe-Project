package com.sfg.springboot.recipeapp.Model;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
@Entity
public class Recipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private Integer prepTime;
	private Integer cookTime;
	private Integer serving;
	private String source;
	private String url;
	private String directions;
	//todo add
	//private Difficulty difficulty;
	@Lob
	private Byte[] image;
	@OneToOne
	private Notes notes;
	
	public Recipe() {
		
	}
	
	public Recipe(String description, Integer prepTime, Integer cookTime, Integer serving, String source, 
			String url,String directions, Byte[] image, Notes notes) {
		super();
		this.description = description;
		this.prepTime = prepTime;
		this.cookTime = cookTime;
		this.serving = serving;
		this.source = source;
		this.url = url;
		this.directions = directions;
		this.image = image;
		this.notes = notes;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Integer getPrepTime() {
		return prepTime;
	}
	
	public void setPrepTime(Integer prepTime) {
		this.prepTime = prepTime;
	}
	
	public Integer getCookTime() {
		return cookTime;
	}
	
	public void setCookTime(Integer cookTime) {
		this.cookTime = cookTime;
	}
	
	public Integer getServing() {
		return serving;
	}
	
	public void setServing(Integer serving) {
		this.serving = serving;
	}
	
	public String getSource() {
		return source;
	}
	
	public void setSource(String source) {
		this.source = source;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getDirections() {
		return directions;
	}
	
	public void setDirections(String directions) {
		this.directions = directions;
	}
	
	public Byte[] getImage() {
		return image;
	}
	
	public void setImage(Byte[] image) {
		this.image = image;
	}
	
	public Notes getNotes() {
		return notes;
	}
	
	public void setNotes(Notes notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "Recipe [description=" + description + ", prepTime=" + prepTime + ", cookTime=" + cookTime + ", serving="
				+ serving + ", source=" + source + ", url=" + url + ", directions=" + directions + ", image="
				+ Arrays.toString(image) + ", notes=" + notes + "]";
	}
	
	
	
}