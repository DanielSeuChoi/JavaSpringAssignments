package daniel.regis.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import daniel.regis.models.LoginUser;
import daniel.regis.models.User;
import daniel.regis.services.UserService;

@Controller
public class MainController {
    @Autowired
    private UserService userService;

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
        return "welcome.jsp";
    }

    @GetMapping("/logout")
    public String logOut(HttpSession session) {
        session.setAttribute("userId", null);
        return "redirect:/";
    }
}
