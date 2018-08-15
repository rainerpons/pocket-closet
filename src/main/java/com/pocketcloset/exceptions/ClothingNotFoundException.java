package com.rainerpons.pocketcloset.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ClothingNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ClothingNotFoundException(String message) {
		super(message);
	}
}