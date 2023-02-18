package daniel.regis.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import daniel.regis.models.LoginUser;
import daniel.regis.models.User;
import daniel.regis.repositories.RegisRepository;

@Service
public class UserService {
    @Autowired
    private RegisRepository regisRepository;

    public User createRegistration(User newUser, BindingResult result) {
        // regisRepository.save(newUser);
        Optional<User> user = regisRepository.findByEmail(newUser.getEmail());
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
        return regisRepository.save(newUser);
    }

    public User login(LoginUser newLogin, BindingResult result) {
        Optional<User> existUser = regisRepository.findByEmail(newLogin.getEmail());
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

    public User findById(Long id) {
        Optional<User> currentUser = regisRepository.findById(id);
        if (currentUser.isPresent()) {
            return currentUser.get();
        } else {
            return null;
        }
    }
}
