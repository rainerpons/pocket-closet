package com.pocketcloset.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "outfits")
public class Outfit {
	private String id;
	private String description;
	private List<Clothing> tops;
	private List<Clothing> bottoms;
	private List<Clothing> footwear;
	private List<Clothing> accessories;

	public Outfit() {
		// Do nothing because of setter-based dependency injection.
	}
}