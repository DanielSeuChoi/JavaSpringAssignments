package com.codingdojo.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/")

public class HomeController {

	@RequestMapping("")
	public String index(
			@RequestParam(name = "name", required = false) String searchQuery,
			@RequestParam(value = "last_name", required = false) String lastQuery,
			@RequestParam(value = "times", required = false) String countTime) {

		return "First Name: " + searchQuery + "  " + "Last Name: " + lastQuery + "  " + "Time: " + countTime;
		// ,String searchQuery2
		// ,value=
		// +"&"+ "Last Name: "+searchQuery2
	}
}
