package com.rainerpons.pocketcloset.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rainerpons.pocketcloset.exceptions.OutfitNotFoundException;
import com.rainerpons.pocketcloset.models.Outfit;
import com.rainerpons.pocketcloset.repositories.OutfitRepository;

@RestController
@RequestMapping("/api/outfits")
public class OutfitController {
	@Autowired
	OutfitRepository outfitRepository;

	@PostMapping
	public Outfit create(@RequestBody Outfit outfit) {
		return outfitRepository.save(outfit);
	}

	@GetMapping("/{id}")
	public Outfit read(@PathVariable String id) throws OutfitNotFoundException {
		Optional<Outfit> outfit = outfitRepository.findById(id);
		if (!outfit.isPresent()) {
			String message = String.format("No outfit with id %s", id);
			throw new OutfitNotFoundException(message);
		}
		return outfit.get();
	}

	@GetMapping
	public List<Outfit> readAll() {
		return outfitRepository.findAll();
	}

	@PutMapping("/{id}")
	public Outfit update(@RequestBody Outfit outfit) {
		return outfitRepository.save(outfit);
	}

	@DeleteMapping("/{id}")
	public Outfit delete(@PathVariable String id) throws OutfitNotFoundException {
		Optional<Outfit> optional = outfitRepository.findById(id);
		if (!optional.isPresent()) {
			String message = String.format("No outfit with the requested id %s", id);
			throw new OutfitNotFoundException(message);
		}
		Outfit outfit = optional.get();
		outfitRepository.delete(outfit);
		return outfit;
	}
}