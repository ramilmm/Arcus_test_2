package ru.veusdas.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.veusdas.Model.User;
import ru.veusdas.Repository.UserRepository;

@RestController
public class ProfileController {

    @Autowired
    private UserRepository userRepository;

    @CrossOrigin
    @GetMapping("/api/getUserInfo")
    @ResponseBody
    public User getUserInfo(@RequestParam("username") String username) {
        System.out.println(username);
        User user = userRepository.findByUsername(username);
        return user;
    }
}
