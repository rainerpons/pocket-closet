package com.rainerpons.pocketcloset.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rainerpons.pocketcloset.model.Clothing;
import com.rainerpons.pocketcloset.repository.ClothingRepository;

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
		return "redirect:/show/" + clothing.getId();
	}

	@RequestMapping("/clothing")
	public String clothing(Model model) {
		model.addAttribute("clothingList", clothingRepository.findAll());
		return "clothing";
	}

	@RequestMapping("/show/{id}")
	public String show(@PathVariable String id, Model model) {
		Optional<Clothing> optional = clothingRepository.findById(id);
		if (optional.isPresent()) {
			Clothing clothing = optional.get();
			model.addAttribute("clothing", clothing);
		}
		return "show";
	}

	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable String id, Model model) {
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
			return "redirect:/show/" + clothing.getId();
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