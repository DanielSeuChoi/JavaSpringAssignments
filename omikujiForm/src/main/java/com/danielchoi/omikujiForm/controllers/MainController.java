package com.danielchoi.omikujiForm.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping(value="/createOmikuji", method=RequestMethod.POST)
	public String view(
			@RequestParam(value="pickNum") String pickNum,
			@RequestParam(value="city")String city,
			@RequestParam(value="person")String person,
			@RequestParam(value="profession")String profession,
			@RequestParam(value="living")String living,
			@RequestParam(value="nice")String nice,
			HttpSession session
			) {
		session.setAttribute("pickNum", pickNum);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("profession", profession);
		session.setAttribute("living", living);
		session.setAttribute("nice", nice);
		return "redirect:/show";
	}
	@RequestMapping("/show")
	public String home() {
		return "view.jsp";
	}
}
