package enrol.springbootenrol.controllers;

import enrol.springbootenrol.modeles.User;
import enrol.springbootenrol.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/spring-boot-enrol/src/website/form_reg.html")
    public String getSignUpPage() {
        return "signUp_page";
    }

    @PostMapping("/spring-boot-enrol/src/website/form_reg.html")
    public String signUpUser(User user) {
        usersRepository.save(user);
        return "signUp_page";
    }
}
