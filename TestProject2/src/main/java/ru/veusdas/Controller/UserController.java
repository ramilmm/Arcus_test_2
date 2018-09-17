package ru.veusdas.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.veusdas.Model.User;
import ru.veusdas.Repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @CrossOrigin
    @PostMapping("/sign-up")
    public void signUp(@RequestBody User user) {
        User userItem = userRepository.findByUsername(user.getUsername());
        System.out.println(userItem);
        if (userItem == null) {
            System.out.println(user);
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userRepository.save(user);
        }
    }

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

}
