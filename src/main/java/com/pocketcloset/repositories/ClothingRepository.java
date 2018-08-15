package com.rainerpons.pocketcloset.repositories;

import com.rainerpons.pocketcloset.models.Clothing;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClothingRepository extends MongoRepository<Clothing, String> {
	List<Clothing> findByTypeEqualsIgnoreCase(String type);
}