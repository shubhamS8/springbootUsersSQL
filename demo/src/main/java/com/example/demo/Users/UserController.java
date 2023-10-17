package com.example.demo.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public ModelAndView getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/addForm")
    public ModelAndView addForm() {
        return userService.addForm();
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/list";
    }

    @GetMapping("/updateForm")
    public ModelAndView showUpdateForm(@RequestParam Long userId) {
        return userService.showUpdateForm(userId);
    }
}
