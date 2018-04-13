package com.rainerpons.pocketcloset.model;

import org.springframework.data.mongodb.core.mapping.Document;

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
}