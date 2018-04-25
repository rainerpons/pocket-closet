package com.rainerpons.pocketcloset.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rainerpons.pocketcloset.models.Outfit;

public interface OutfitRepository extends MongoRepository<String, Outfit> {

}