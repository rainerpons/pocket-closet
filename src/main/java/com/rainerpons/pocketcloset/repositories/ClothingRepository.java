package com.rainerpons.pocketcloset.repositories;

import com.rainerpons.pocketcloset.models.Clothing;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClothingRepository extends MongoRepository<Clothing, String> {

}