package daniel.bookclub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String welcome(@ModelAttribute("book") Book book, HttpSession session, Model model) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/logout";
        }
        List<Book> books = bookService.allPost();
        Long userId = (Long) session.getAttribute("userId");
        User user = userService.findById(userId);
        model.addAttribute("user", user);
        model.addAttribute("books", books);
        return "welcome.jsp";
    }

    @GetMapping("/logout")
    public String logOut(HttpSession session) {
        session.setAttribute("userId", null);
        return "redirect:/";
    }

    @GetMapping("/books/new")
    public String showBooks(Model model) {
        model.addAttribute("books", new Book());
        return "book.jsp";
    }

    @PostMapping("/createpost")
    public String createPosts(@Valid @ModelAttribute("books") Book books,
            BindingResult result, Model model, HttpSession session) {
        Book book = bookService.createPost(books);
        model.addAttribute("newPost", book);
        return "book.jsp";
    }
    // BOOK Controllers

}
