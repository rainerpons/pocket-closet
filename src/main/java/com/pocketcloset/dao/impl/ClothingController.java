package com.pocketcloset.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pocketcloset.dao.ClothingDao;
import com.pocketcloset.exceptions.ClothingNotFoundException;
import com.pocketcloset.models.Clothing;
import com.pocketcloset.repositories.ClothingRepository;

@RestController
@RequestMapping("/api/clothing")
public class ClothingController implements ClothingDao {
	@Autowired
	ClothingRepository clothingRepository;

	@Override
	@PostMapping
	public Clothing create(Clothing clothing) {
		return clothingRepository.save(clothing);
	}

	@Override
	@GetMapping("/{id}")
	public Clothing read(String id) throws ClothingNotFoundException {
		Optional<Clothing> clothing = clothingRepository.findById(id);
		if (!clothing.isPresent()) {
			String message = String.format("No clothing with id %s", id);
			throw new ClothingNotFoundException(message);
		}
		return clothing.get();
	}

	@Override
	@GetMapping("/type/{type}")
	public List<Clothing> readByType(String type) {
		return clothingRepository.findAllByTypeEqualsIgnoreCase(type);
	}

	@Override
	@GetMapping
	public List<Clothing> readAll() {
		return clothingRepository.findAll();
	}

	@Override
	@PutMapping("/{id}")
	public Clothing update(Clothing clothing) {
		return clothingRepository.save(clothing);
	}

	@Override
	@DeleteMapping("/{id}")
	public Clothing delete(String id) throws ClothingNotFoundException {
		Optional<Clothing> optional = clothingRepository.findById(id);
		if (!optional.isPresent()) {
			String message = String.format("No clothing with the requested id %s", id);
			throw new ClothingNotFoundException(message);
		}
		Clothing clothing = optional.get();
		clothingRepository.delete(clothing);
		return clothing;
	}
}