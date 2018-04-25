package com.rainerpons.pocketcloset.repository;

import com.rainerpons.pocketcloset.model.Clothing;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClothingRepository extends MongoRepository<Clothing, String> {

}