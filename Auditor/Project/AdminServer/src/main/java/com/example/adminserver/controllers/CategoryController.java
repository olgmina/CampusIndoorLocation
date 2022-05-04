package com.example.adminserver.controllers;

import com.example.adminserver.models.Category;
import com.example.adminserver.models.Organizational;
import com.example.adminserver.reposutoryes.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller

public class CategoryController {
    private Category category;
    @Autowired
    private UsersRepository usersRepository;

    @GetMapping ("/users")
    public String getUsersPage(Model model) {
        List<Organizational> organizational = usersRepository.findAll();
        model.addAttribute("users", organizational);
        return "users_page";
    }
}
