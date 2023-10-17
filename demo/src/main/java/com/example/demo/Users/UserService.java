package com.example.demo.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ModelAndView getUsers() {
        ModelAndView modelAndView = new ModelAndView("listUsers");
        modelAndView.addObject("users", userRepository.findAll());
        return modelAndView;
    }

    public ModelAndView addForm() {
        ModelAndView modelAndView = new ModelAndView("addForm");
        User newUser = new User();
        modelAndView.addObject("user", newUser);
        return modelAndView;
    }

    public String saveUser(@ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/list";
    }

    public ModelAndView showUpdateForm(@RequestParam Long userId) {
        ModelAndView modelAndView = new ModelAndView("addForm");
        User user = userRepository.findById(userId).get();
        modelAndView.addObject("user", user);
        return modelAndView;
    }
}
