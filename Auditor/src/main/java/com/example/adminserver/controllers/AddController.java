package com.example.adminserver.controllers;

import com.example.adminserver.models.Organizational;
import com.example.adminserver.reposutoryes.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AddController {
    @Autowired
    private UsersRepository usersRepository;
    @GetMapping ("/signUp")
    public String getSignUpPage(){
        return "signUp_page";
    }
    @GetMapping ("/users")
    public String getUsersPage(Model model) {
        List<Organizational> organizational = usersRepository.findAll();
        model.addAttribute("organizationals", organizational);
        return "users_page";
    }
    @PostMapping ("/signUp")
    public String singUpUser(Organizational organizational) {
        usersRepository.save(organizational);
        return "redirect:/signUp";
    }
    @DeleteMapping ("/delete/{id}")
    public void delete(@PathVariable long id) {
        usersRepository.deleteById(id);
    }
    @RequestMapping ("/amount/category/{category}")
    @ResponseBody
    public int getAmountOfCategory(@PathVariable String category) {
        switch (category) {
            case "org":
                category = "Организационное";
                break;
            case "uch":
                category = "Учебное";
                break;
            case "neu":
                category = "Внеучебное";
                break;
            default:
                break;
        }
        return usersRepository.findByCategory(category);
    }
    @RequestMapping ("/amount/status/{status}")
    @ResponseBody
    public int getAmountOfStatus(@PathVariable String status) {
        switch (status) {
            case "prov":
                status = "Проведено";
                break;
            case "ozh":
                status = "Ожидается";
                break;
            case "otm":
                status = "Отменено";
                break;
            default:
                break;
        }
        return usersRepository.findByStatus(status);
    }
}
