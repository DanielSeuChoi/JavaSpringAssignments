package com.daniel.humanworlds.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.daniel.humanworlds.models.Book;
import com.daniel.humanworlds.services.BookService;

@Controller
public class BookController {

	@Autowired
	BookService bookService;

	@GetMapping("/")
	public String index(
			Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "index.jsp";
	}

	// @RequestMapping(value="/createBook", method=RequestMethod.POST)
	// public String view(
	// @RequestParam(value="title") String title,
	// @RequestParam(value="description")String description,
	// @RequestParam(value="language")String language,
	// @RequestParam(value="numOfPages")String numOfPages,
	// HttpSession session
	// ) {
	// session.setAttribute("title", title);
	// session.setAttribute("description", description);
	// session.setAttribute("language", language);
	// session.setAttribute("numOfPages", numOfPages);
	// return "redirect:/show";
	// }

	// @RequestMapping("/show")
	// public String home() {
	// return "view.jsp";
	// }
}
