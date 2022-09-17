package ru.kata.spring.boot_security.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.service.UserServiceImp;
import ru.kata.spring.boot_security.demo.model.User;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserServiceImp userServiceImp;

    @Autowired
    public AdminController(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;

    }



    @GetMapping("/users")
    public String sayUsers(Model model) {
        model.addAttribute("users", userServiceImp.findAll());
        return "users";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("new_user", new User());
        return "new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("user") User user) {
        userServiceImp.saveRole(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userServiceImp.findById(id));
        return "update";
    }

    @PatchMapping("/update/{id}")
    public String updateUsers(@ModelAttribute("user") User user) {
        userServiceImp.saveRole(user);
        return "redirect:/admin/users";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userServiceImp.deleteById(id);
        return "redirect:/admin/users";
    }
}
