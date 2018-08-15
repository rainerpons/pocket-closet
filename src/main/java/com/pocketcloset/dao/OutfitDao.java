package com.pocketcloset.dao;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.pocketcloset.exceptions.OutfitNotFoundException;
import com.pocketcloset.models.Outfit;

public interface OutfitDao {
	public Outfit create(@RequestBody Outfit outfit);

	public Outfit read(@PathVariable String id) throws OutfitNotFoundException;

	public List<Outfit> readAll();

	public Outfit update(@RequestBody Outfit outfit);

	public Outfit delete(@PathVariable String id) throws OutfitNotFoundException;
}