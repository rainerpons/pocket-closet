package com.rainerpons.pocketcloset.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "clothing")
public class Clothing {
	private String id;
	private String type;
	private String color;
	private String brand;
	private String info;

	public Clothing() {
		// Do nothing because of setter-based dependency injection.
	}
}