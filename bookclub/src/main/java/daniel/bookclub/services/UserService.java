package daniel.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import daniel.bookclub.models.LoginUser;
import daniel.bookclub.models.User;
import daniel.bookclub.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    public User createRegistration(User newUser, BindingResult result) {
        // userRepo.save(newUser);
        Optional<User> user = userRepo.findByEmail(newUser.getEmail());
        if (user.isPresent()) {
            result.rejectValue("email", "Email", "Email is already registered");
        }
        if (!newUser.getPassword().equals(newUser.getConfirm())) {
            result.rejectValue("confirm", "Confirm", "Passwords must match");
        }
        if (result.hasErrors()) {
            return null;
        }
        String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashed);
        return userRepo.save(newUser);
    }

    public User login(LoginUser newLogin, BindingResult result) {
        Optional<User> existUser = userRepo.findByEmail(newLogin.getEmail());
        if (!existUser.isPresent()) {
            result.rejectValue("email", "Email", "User not found");
            return null;
        }
        User user = existUser.get();
        if (!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
            result.rejectValue("password", "Matches", "Invalid Password!");
        }
        if (result.hasErrors()) {
            return null;
        }
        return user;
    }

    public List<User> allUsers() {
        return userRepo.findAll();
    }

    public User findById(Long id) {
        Optional<User> currentUser = userRepo.findById(id);
        if (currentUser.isPresent()) {
            return currentUser.get();
        } else {
            return null;
        }
    }

    public User savePosts(User user) {
        return userRepo.save(user);
    }
}
