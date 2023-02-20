package daniel.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import daniel.bookclub.models.Book;
import daniel.bookclub.models.LoginUser;
import daniel.bookclub.models.User;
import daniel.bookclub.services.BookService;
import daniel.bookclub.services.UserService;

@Controller
public class MainController {
    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser,
            BindingResult result, Model model, HttpSession session) {
        User user = userService.createRegistration(newUser, result);
        if (result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        session.setAttribute("userId", user.getId());
        return "redirect:/welcome";
    }

    @PostMapping("/login")
    public String loginUser(@Valid @ModelAttribute("newLogin") LoginUser newLogin,
            BindingResult result, Model model, HttpSession session) {
        User user = userService.login(newLogin, result);
        // String existUser = (String) session.getAttribute("userId");
        if (result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        session.setAttribute("userId", user.getId());
        return "redirect:/welcome";
    }

    @GetMapping("/welcome")
    public String welcome(HttpSession session, Model model) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/logout";
        }
        Long userId = (Long) session.getAttribute("userId");
        User user = userService.findById(userId);
        model.addAttribute("user", user);
        model.addAttribute("books", bookService.allPost());
        return "welcome.jsp";
    }

    @GetMapping("/logout")
    public String logOut(HttpSession session) {
        session.setAttribute("userId", null);
        return "redirect:/";
    }

    @GetMapping("/books/new")
    public String showBooks(@ModelAttribute("book") Book book, HttpSession session, Model model) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/logout";
        }
        Long userId = (Long) session.getAttribute("userId");
        User user = userService.findById(userId);
        model.addAttribute("user", user);
        return "book.jsp";
    }

    @PostMapping("/books/new")
    public String createPosts(@Valid @ModelAttribute("book") Book book,
            BindingResult result, HttpSession session) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/logout";
        }
        if (result.hasErrors()) {
            return "book.jsp";
        } else {
            bookService.createPost(book);
            Long userId = (Long) session.getAttribute("userId");
            User user = userService.findById(userId);
            user.getBooks().add(book);
            userService.savePosts(user);
            return "redirect:/welcome";
        }
    }

    // BOOK Controllers
    @GetMapping("/books/{id}")
    public String showOneBook(@PathVariable("id") Long id,
            HttpSession session, Model model) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/logout";
        }
        Book book = bookService.findById(id);
        Long userId = (Long) session.getAttribute("userId");
        User user = userService.findById(id);
        model.addAttribute("user", user);
        model.addAttribute("userId", userId);
        model.addAttribute("book", book);
        return "onebook.jsp";
    }

    @GetMapping("/books/{id}/edit")
    public String editPage(@PathVariable("id") Long id, Model model, HttpSession session) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/logout";
        }
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "edit.jsp";
    }

    @PutMapping("/books/{id}")
    public String updateBook(Model model, @Valid @ModelAttribute("book") Book book, BindingResult result,
            HttpSession session) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/logout";
        }
        if (result.hasErrors()) {
            return "edit.jsp";
        }
        bookService.update(book);
        return "redirect:/welcome";
    }

    @GetMapping("/books/{id}/delete")
    public String deleteBooks(@PathVariable("id") Long id, HttpSession session) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/logout";
        }
        Book book = bookService.findById(id);
        bookService.delete(book);
        return "redirect:/welcome";
    }
}
