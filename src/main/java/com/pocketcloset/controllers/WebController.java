package com.pocketcloset.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/clothing/create")
	public String createClothing() {
		return "clothing/create";
	}

	@RequestMapping("/clothing/view")
	public String viewClothing() {
		return "clothing/view";
	}
	
	@RequestMapping("/outfits/view")
	public String viewOutfit() {
		return "outfits/view";
	}
}