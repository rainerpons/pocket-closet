package com.rainerpons.pocketcloset.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class OutfitNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public OutfitNotFoundException(String message) {
		super(message);
	}
}