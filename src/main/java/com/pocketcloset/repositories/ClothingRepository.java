package com.pocketcloset.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.pocketcloset.models.Clothing;

public interface ClothingRepository extends MongoRepository<Clothing, String> {
	@Query("{ db.clothing.find({'type' : ?0 }).limit(1).skip(_rand() * db.clothing.count({ 'type' : ?0 })) }")
	Optional<Clothing> findByTypeEqualsIgnoreCase(String type);

	List<Clothing> findAllByTypeEqualsIgnoreCase(String type);
	
	List<Clothing> findAllByDescriptionEqualsIgnoreCase(String description);
}