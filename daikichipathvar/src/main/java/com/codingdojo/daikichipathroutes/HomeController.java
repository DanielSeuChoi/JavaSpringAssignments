package com.codingdojo.daikichipathroutes;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("daikichi")
public class HomeController {
	@RequestMapping("/travel/{city}")
	public String showCity(@PathVariable("city") String city) {
		return "Congratulations! You will soon travel to " + city;
	}

	@RequestMapping("/lotto/{num}")
	public String showOddEven(@PathVariable("num") int num) {
		if (num % 2 == 0) {
			return "You will take a grand journey in the near future, but be weary of tempting offers";
		}
		return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends";
	}
}
