package com.example.adminserver.controllers;

import com.example.adminserver.models.Organizational;
import com.example.adminserver.reposutoryes.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddController {
    @Autowired
    private UsersRepository usersRepository;
@GetMapping("/signUp")
    public String getSignUpPage(){
        return "signUp_page";
    }
    @PostMapping ("/signUp")
    public String singUpUser(Organizational organizational) {
        usersRepository.save(organizational);
        return "redirect:/signUp_page";
    }
}
