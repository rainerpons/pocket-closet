package com.rainerpons.pocketcloset.controller;

import com.rainerpons.pocketcloset.repository.ClothingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ClothingController {
	@Autowired
	ClothingRepository clothingRepository;
}