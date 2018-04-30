package com.rainerpons.pocketcloset.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/clothing/create")
	public String create() {
		return "clothing/create";
	}

	@RequestMapping("/clothing/view")
	public String view() {
		return "clothing/view";
	}
}