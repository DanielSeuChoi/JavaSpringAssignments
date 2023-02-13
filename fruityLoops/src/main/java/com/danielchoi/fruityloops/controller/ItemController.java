package com.danielchoi.fruityloops.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.danielchoi.fruityloops.models.Item;

import org.springframework.ui.Model;

@Controller
public class ItemController {
	
	@RequestMapping("/")
	public String index(Model model) {
        ArrayList<Item> fruits = new ArrayList<Item>();
        fruits.add(new Item("Kiwi", 1.5));
        fruits.add(new Item("Mango", 2.0));
        fruits.add(new Item("Goji Berries", 4.0));
        fruits.add(new Item("Guava", .75));
        model.addAttribute("fruitsControl", fruits);
		return "index.jsp";
	}
}
