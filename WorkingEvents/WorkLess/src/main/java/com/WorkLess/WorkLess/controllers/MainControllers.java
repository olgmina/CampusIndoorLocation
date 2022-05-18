package com.WorkLess.WorkLess.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainControllers {

    @GetMapping("/")
    public String greeting(Model model) {
        model.addAttribute("title", "Планировщик обновления расписания");
        return "home";
    }
}
