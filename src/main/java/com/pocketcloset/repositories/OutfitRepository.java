package com.pocketcloset.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pocketcloset.models.Outfit;

public interface OutfitRepository extends MongoRepository<Outfit, String> {

}