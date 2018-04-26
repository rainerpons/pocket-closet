package com.rainerpons.pocketcloset.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rainerpons.pocketcloset.models.Clothing;
import com.rainerpons.pocketcloset.repositories.ClothingRepository;

@Controller
public class ClothingController {
	@Autowired
	ClothingRepository clothingRepository;

	@RequestMapping("/create")
	public String create(Model model) {
		return "create";
	}

	@RequestMapping("/save")
	public String save(@RequestParam String type, @RequestParam String color,
			@RequestParam String brand, @RequestParam String info) {
		Clothing clothing = new Clothing();
		clothing.setType(type);
		clothing.setColor(color);
		clothing.setBrand(brand);
		clothing.setInfo(info);
		clothingRepository.save(clothing);
		return "redirect:/show?id=" + clothing.getId();
	}

	@RequestMapping("/clothing")
	public String clothing(Model model) {
		model.addAttribute("clothingList", clothingRepository.findAll());
		return "clothing";
	}

	@RequestMapping("/show")
	public String show(@RequestParam String id, Model model) {
		Optional<Clothing> optional = clothingRepository.findById(id);
		if (optional.isPresent()) {
			Clothing clothing = optional.get();
			model.addAttribute("clothing", clothing);
		}
		return "show";
	}

	@RequestMapping("/edit")
	public String edit(@RequestParam String id, Model model) {
		Optional<Clothing> optional = clothingRepository.findById(id);
		if (optional.isPresent()) {
			Clothing clothing = optional.get();
			model.addAttribute("clothing", clothing);
		}
		return "edit";
	}

	@RequestMapping("/update")
	public String update(@RequestParam String id, @RequestParam String type,
			@RequestParam String color, @RequestParam String brand, @RequestParam String info) {
		Optional<Clothing> optional = clothingRepository.findById(id);
		if (optional.isPresent()) {
			Clothing clothing = optional.get();
			clothing.setType(type);
			clothing.setColor(color);
			clothing.setBrand(brand);
			clothing.setInfo(info);
			clothingRepository.save(clothing);
		}
		return "redirect:/clothing";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam String id) {
		Optional<Clothing> optional = clothingRepository.findById(id);
		if (optional.isPresent()) {
			Clothing clothing = optional.get();
			clothingRepository.delete(clothing);
		}
		return "redirect:/clothing";
	}
}