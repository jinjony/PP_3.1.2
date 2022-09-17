package ru.kata.spring.boot_security.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.service.UserServiceImp;

import java.security.Principal;

@Controller
public class UserController {

    private final UserServiceImp userServiceImp;
    @Autowired
    public UserController(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @GetMapping("/")
    public String sayHome() {
        return "index";
    }

    @GetMapping("/user")
    public String sayUsers(Principal principal,Model model) {
        model.addAttribute("user",userServiceImp.findByUsername(principal.getName()));
        return "user";
    }

//    @GetMapping("/new")
//    public String newUser(Model model) {
//        model.addAttribute("new_user", new User());
//        return "new";
//    }
//
//    @PostMapping("/users")
//    public String create(@ModelAttribute("user") User user) {
//        userServiceImp.saveUser(user);
//        return "redirect:/users";
//    }
//
//    @GetMapping("{id}/update")
//    public String updateUser(@PathVariable("id") Long id, Model model) {
//        model.addAttribute("user", userServiceImp.findById(id));
//        return "update";
//    }
//
//    @PostMapping("{id}/updateUser")
//    public String updateUsers(@ModelAttribute("user") User user) {
//        userServiceImp.saveUser(user);
//        return "redirect:/users";
//    }
//
//    @PostMapping("{id}/delete")
//    public String deleteUser(@PathVariable("id") Long id) {
//        userServiceImp.deleteById(id);
//        return "redirect:/users";
//    }
}