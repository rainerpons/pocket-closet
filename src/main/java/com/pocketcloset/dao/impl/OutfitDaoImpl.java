package com.pocketcloset.dao.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pocketcloset.dao.OutfitDao;
import com.pocketcloset.exceptions.ClothingNotFoundException;
import com.pocketcloset.exceptions.OutfitNotFoundException;
import com.pocketcloset.models.Clothing;
import com.pocketcloset.models.Outfit;
import com.pocketcloset.repositories.ClothingRepository;
import com.pocketcloset.repositories.OutfitRepository;

@RestController
@RequestMapping("/api/outfits")
public class OutfitDaoImpl implements OutfitDao {
	@Autowired
	ClothingRepository clothingRepository;
	@Autowired
	OutfitRepository outfitRepository;

	@Override
	@PostMapping
	public Outfit create(@RequestBody Outfit outfit) {
		return outfitRepository.save(outfit);
	}

	@PostMapping("/random")
	public Outfit createRandom() throws ClothingNotFoundException {
		Outfit outfit = new Outfit();
		outfit.setDescription("Randomly generated");
		outfit.setTops(randomClothingByType("Top"));
		outfit.setBottoms(randomClothingByType("Bottom"));
		outfit.setFootwear(randomClothingByType("Footwear"));

		Random random = new Random();
		if (random.nextFloat() < 0.5) {
			try {
				outfit.setAccessories(randomClothingByType("Accessory"));
			} catch (ClothingNotFoundException e) {
				return outfitRepository.save(outfit);
			}
		}
		return outfitRepository.save(outfit);
	}

	@Override
	@GetMapping("/{id}")
	public Outfit read(@PathVariable String id) throws OutfitNotFoundException {
		Optional<Outfit> outfit = outfitRepository.findById(id);
		if (!outfit.isPresent()) {
			String message = String.format("No outfit with id %s", id);
			throw new OutfitNotFoundException(message);
		}
		return outfit.get();
	}

	@Override
	@GetMapping
	public List<Outfit> readAll() {
		return outfitRepository.findAll();
	}

	@Override
	@PutMapping("/{id}")
	public Outfit update(@RequestBody Outfit outfit) {
		return outfitRepository.save(outfit);
	}

	@Override
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

	private List<Clothing> randomClothingByType(String type) throws ClothingNotFoundException {
		List<Clothing> clothing = clothingRepository.findAllByTypeEqualsIgnoreCase(type);

		if (clothing.size() == 0) {
			String message = String.format("No clothing with type %s found", type);
			throw new ClothingNotFoundException(message);
		}

		Random random = new Random();
		Clothing randomClothing = clothing.get(random.nextInt(clothing.size()));
		return Arrays.asList(randomClothing);
	}
}