package com.sfg.springboot.recipeapp.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UnitOfMesure {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String uom;
	
	public UnitOfMesure() {
		
	}
	
	public UnitOfMesure(Long id, String uom) {
		super();
		this.id = id;
		this.uom = uom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	@Override
	public String toString() {
		return "UnitOfMesure [id=" + id + ", uom=" + uom + "]";
	}
	
}
