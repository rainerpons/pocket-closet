package com.pocketcloset.dao;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.pocketcloset.exceptions.ClothingNotFoundException;
import com.pocketcloset.models.Clothing;

public interface ClothingDao {
	public Clothing create(@RequestBody Clothing clothing);

	public Clothing read(@PathVariable String id) throws ClothingNotFoundException;

	public List<Clothing> readByType(@PathVariable String type);

	public List<Clothing> readAll();

	public Clothing update(@RequestBody Clothing clothing);

	public Clothing delete(@PathVariable String id) throws ClothingNotFoundException;
}