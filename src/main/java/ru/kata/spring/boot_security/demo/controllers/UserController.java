package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kata.spring.boot_security.demo.services.UsersService;
import java.security.Principal;

@Controller
public class UserController {

    private UsersService usersService;

    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/user")
    public String getUsers(Model model,  Principal principal) {
        model.addAttribute("usingUser", usersService.getUserByUsername(principal.getName()));
        return "user";
    }
}
