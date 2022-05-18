package AuthorizationPool.Controllers;

import AuthorizationPool.Models.Policy;
import AuthorizationPool.Models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Objects;

@Controller
public class MainController {

    @GetMapping("/")
    public String login(Model model) {
        model.addAttribute("Title", "Страница входа");
        return "login";
    }
    @GetMapping("/login")
    public String login2(Model model) {
        model.addAttribute("Title", "Страница входа");
        return "login";
    }

    @GetMapping("/userPage")
    public String userPage(Model model, Principal principal){
        model.addAttribute("Title", "Страница Пользователя");
        model.addAttribute("name", principal.getName());
        if(Objects.equals(principal.getName(), user1.getName())){
            model.addAttribute("location", String.valueOf(user1.getPolicy().getLocation()));
            model.addAttribute("date", String.valueOf(user1.getPolicy().getDate()));
            model.addAttribute("staff", String.valueOf(user1.getPolicy().getStaff()));
            model.addAttribute("equipment", String.valueOf(user1.getPolicy().getEquipment()));
            return "userPage";
        }else if(Objects.equals(principal.getName(), user2.getName())){
            model.addAttribute("location", String.valueOf(user2.getPolicy().getLocation()));
            model.addAttribute("date", String.valueOf(user2.getPolicy().getDate()));
            model.addAttribute("staff", String.valueOf(user2.getPolicy().getStaff()));
            model.addAttribute("equipment", String.valueOf(user2.getPolicy().getEquipment()));
            return "userPage";
        }else if(Objects.equals(principal.getName(), user3.getName())){
            model.addAttribute("location", String.valueOf(user3.getPolicy().getLocation()));
            model.addAttribute("date", String.valueOf(user3.getPolicy().getDate()));
            model.addAttribute("staff", String.valueOf(user3.getPolicy().getStaff()));
            model.addAttribute("equipment", String.valueOf(user3.getPolicy().getEquipment()));
            return "userPage";
        }else if(Objects.equals(principal.getName(), user4.getName())){
            model.addAttribute("location", String.valueOf(user4.getPolicy().getLocation()));
            model.addAttribute("date", String.valueOf(user4.getPolicy().getDate()));
            model.addAttribute("staff", String.valueOf(user4.getPolicy().getStaff()));
            model.addAttribute("equipment", String.valueOf(user4.getPolicy().getEquipment()));
            return "userPage";
        }else if(Objects.equals(principal.getName(), user5.getName())){
            model.addAttribute("location", String.valueOf(user5.getPolicy().getLocation()));
            model.addAttribute("date", String.valueOf(user5.getPolicy().getDate()));
            model.addAttribute("staff", String.valueOf(user5.getPolicy().getStaff()));
            model.addAttribute("equipment", String.valueOf(user5.getPolicy().getEquipment()));
            return "userPage";
        }else if(Objects.equals(principal.getName(), "admin")){
            model.addAttribute("location", "100");
            model.addAttribute("date", "100");
            model.addAttribute("staff", "100");
            model.addAttribute("equipment", "100");
            return "userPage";
        }else {
            return "userPage";
        }

    }

    @PostMapping (value = "/userPage")
    public String signUp(@RequestParam String username, @RequestParam String password, Model model){
        if(Objects.equals(username, user1.getName())){
            model.addAttribute("Title", "Страница Пользователя");
            model.addAttribute("Name", user1.getName());
            model.addAttribute("Location", String.valueOf(user1.getPolicy().getLocation()));
            model.addAttribute("Date", String.valueOf(user1.getPolicy().getDate()));
            model.addAttribute("Staff", String.valueOf(user1.getPolicy().getStaff()));
            model.addAttribute("Equipment", String.valueOf(user1.getPolicy().getEquipment()));
            return "userPage";
        }else if(Objects.equals(username, user2.getName())){
            model.addAttribute("Title", "Страница Пользователя");
            model.addAttribute("Name", user2.getName());
            model.addAttribute("Location", String.valueOf(user2.getPolicy().getLocation()));
            model.addAttribute("Date", String.valueOf(user2.getPolicy().getDate()));
            model.addAttribute("Staff", String.valueOf(user2.getPolicy().getStaff()));
            model.addAttribute("Equipment", String.valueOf(user2.getPolicy().getEquipment()));
            return "userPage";
        }else if(Objects.equals(username, user3.getName())){
            model.addAttribute("Title", "Страница Пользователя");
            model.addAttribute("Name", user3.getName());
            model.addAttribute("Location", String.valueOf(user3.getPolicy().getLocation()));
            model.addAttribute("Date", String.valueOf(user3.getPolicy().getDate()));
            model.addAttribute("Staff", String.valueOf(user3.getPolicy().getStaff()));
            model.addAttribute("Equipment", String.valueOf(user3.getPolicy().getEquipment()));
            return "userPage";
        }else if(Objects.equals(username, user4.getName())){
            model.addAttribute("Title", "Страница Пользователя");
            model.addAttribute("Name", user4.getName());
            model.addAttribute("Location", String.valueOf(user4.getPolicy().getLocation()));
            model.addAttribute("Date", String.valueOf(user4.getPolicy().getDate()));
            model.addAttribute("Staff", String.valueOf(user4.getPolicy().getStaff()));
            model.addAttribute("Equipment", String.valueOf(user4.getPolicy().getEquipment()));
            return "userPage";
        }else if(Objects.equals(username, user5.getName())){
            model.addAttribute("Title", "Страница Пользователя");
            model.addAttribute("Name", user5.getName());
            model.addAttribute("Location", String.valueOf(user5.getPolicy().getLocation()));
            model.addAttribute("Date", String.valueOf(user5.getPolicy().getDate()));
            model.addAttribute("Staff", String.valueOf(user5.getPolicy().getStaff()));
            model.addAttribute("Equipment", String.valueOf(user5.getPolicy().getEquipment()));
            return "userPage";
        }else{
            return "403Page";
        }
    }

    @GetMapping("/admin")
    public String adminPage(Model model, Principal principal){
        model.addAttribute("Title", "Страница Администратора");

        model.addAttribute("name1", user1.getName());
        model.addAttribute("pass1", user1.getPassword());
        model.addAttribute("loca1", String.valueOf(user1.getPolicy().getLocation()));
        model.addAttribute("date1", String.valueOf(user1.getPolicy().getDate()));
        model.addAttribute("staff1", String.valueOf(user1.getPolicy().getStaff()));
        model.addAttribute("eq1", String.valueOf(user1.getPolicy().getEquipment()));

        model.addAttribute("name2", user2.getName());
        model.addAttribute("pass2", user2.getPassword());
        model.addAttribute("loca2", String.valueOf(user2.getPolicy().getLocation()));
        model.addAttribute("date2", String.valueOf(user2.getPolicy().getDate()));
        model.addAttribute("staff2", String.valueOf(user2.getPolicy().getStaff()));
        model.addAttribute("eq2", String.valueOf(user2.getPolicy().getEquipment()));

        model.addAttribute("name3", user3.getName());
        model.addAttribute("pass3", user3.getPassword());
        model.addAttribute("loca3", String.valueOf(user3.getPolicy().getLocation()));
        model.addAttribute("date3", String.valueOf(user3.getPolicy().getDate()));
        model.addAttribute("staff3", String.valueOf(user3.getPolicy().getStaff()));
        model.addAttribute("eq3", String.valueOf(user3.getPolicy().getEquipment()));

        model.addAttribute("name4", user4.getName());
        model.addAttribute("pass4", user4.getPassword());
        model.addAttribute("loca4", String.valueOf(user4.getPolicy().getLocation()));
        model.addAttribute("date4", String.valueOf(user4.getPolicy().getDate()));
        model.addAttribute("staff4", String.valueOf(user4.getPolicy().getStaff()));
        model.addAttribute("eq4", String.valueOf(user4.getPolicy().getEquipment()));

        model.addAttribute("name5", user5.getName());
        model.addAttribute("pass5", user5.getPassword());
        model.addAttribute("loca5", String.valueOf(user5.getPolicy().getLocation()));
        model.addAttribute("date5", String.valueOf(user5.getPolicy().getDate()));
        model.addAttribute("staff5", String.valueOf(user5.getPolicy().getStaff()));
        model.addAttribute("eq5", String.valueOf(user5.getPolicy().getEquipment()));

        return "adminPage";
    }

    @GetMapping("/edit")
    public String emptyEdit(Model model){
        model.addAttribute("Title", "Редактирование пользователя");
        return "forEdit/edit";
    }

    @GetMapping("/edit1")
    public String emptyEdit1(Model model){
        model.addAttribute("Title", "Редактирование пользователя");
        model.addAttribute("name", user1.getName());
        return "forEdit/edit1";
    }

    @GetMapping("/edit2")
    public String emptyEdit2(Model model){
        model.addAttribute("Title", "Редактирование пользователя");
        model.addAttribute("name", user2.getName());
        return "forEdit/edit2";
    }

    @GetMapping("/edit3")
    public String emptyEdit3(Model model){
        model.addAttribute("Title", "Редактирование пользователя");
        model.addAttribute("name", user3.getName());
        return "forEdit/edit3";
    }

    @GetMapping("/edit4")
    public String emptyEdit4(Model model){
        model.addAttribute("Title", "Редактирование пользователя");
        model.addAttribute("name", user4.getName());
        return "forEdit/edit4";
    }

    @GetMapping("/edit5")
    public String emptyEdit5(Model model){
        model.addAttribute("Title", "Редактирование пользователя");
        model.addAttribute("name", user5.getName());
        return "forEdit/edit5";
    }


    @PostMapping("/edit1")
    public String edit1(@RequestParam String location, @RequestParam String date, @RequestParam String staff, @RequestParam String equipment, Model model){
        model.addAttribute("Title", "Редактирование пользователя");
        Policy p = new Policy(Integer.parseInt(location),Integer.parseInt(date),Integer.parseInt(staff),Integer.parseInt(equipment));
        user1.setPolicy(p);
        return "forEdit/edit1";
    }

    @PostMapping("/edit2")
    public String edit2(@RequestParam String location, @RequestParam String date, @RequestParam String staff, @RequestParam String equipment, Model model){
        model.addAttribute("Title", "Редактирование пользователя");
        Policy p = new Policy(Integer.parseInt(location),Integer.parseInt(date),Integer.parseInt(staff),Integer.parseInt(equipment));
        user2.setPolicy(p);
        return "forEdit/edit2";
    }

    @PostMapping("/edit3")
    public String edit3(@RequestParam String location, @RequestParam String date, @RequestParam String staff, @RequestParam String equipment, Model model){
        model.addAttribute("Title", "Редактирование пользователя");
        Policy p = new Policy(Integer.parseInt(location),Integer.parseInt(date),Integer.parseInt(staff),Integer.parseInt(equipment));
        user3.setPolicy(p);
        return "forEdit/edit3";
    }

    @PostMapping("/edit4")
    public String edit4(@RequestParam String location, @RequestParam String date, @RequestParam String staff, @RequestParam String equipment, Model model){
        model.addAttribute("Title", "Редактирование пользователя");
        Policy p = new Policy(Integer.parseInt(location),Integer.parseInt(date),Integer.parseInt(staff),Integer.parseInt(equipment));
        user4.setPolicy(p);
        return "forEdit/edit4";
    }

    @PostMapping("/edit5")
    public String edit5(@RequestParam String location, @RequestParam String date, @RequestParam String staff, @RequestParam String equipment, Model model){
        model.addAttribute("Title", "Редактирование пользователя");
        Policy p = new Policy(Integer.parseInt(location),Integer.parseInt(date),Integer.parseInt(staff),Integer.parseInt(equipment));
        user5.setPolicy(p);
        return "forEdit/edit5";
    }

    @PostMapping("/edit")
    public String edit(@RequestParam String location, @RequestParam String date, @RequestParam String staff, @RequestParam String equipment, Model model){
        model.addAttribute("Title", "Редактирование пользователя");
        return "forEdit/edit";
    }

    User user1 = new User("Хмельнин А.С.","3232", new Policy(5,3,2,1));
    User user2 = new User("Захаева А.А.","3232", new Policy(3,5,2,1));
    User user3 = new User("Вахаев Б.П.","3232", new Policy(2,3,4,2));
    User user4 = new User("Лучикова Н.Г.","3232", new Policy(3,4,2,1));
    User user5 = new User("Красаев Н.Е.","3232", new Policy(4,3,4,2));

}