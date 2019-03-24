package pl.coderslab.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.FakeUser;
import pl.coderslab.model.Family;
import pl.coderslab.model.User;
import pl.coderslab.service.FamilyService;
import pl.coderslab.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
@SessionAttributes("logged")

public class HomeController {


    @Autowired
    private UserService userService;

    @Autowired
    private FamilyService familyService;

    @RequestMapping
    public String homepage() {

        return "home";
    }

    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "users/register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid User user, BindingResult result, @RequestParam String familyName) {
        if (result.hasErrors()) {
            return "redirect:/register";
        } else {
            Family family1 = new Family();
            family1.setName(familyName);
            familyService.saveFamily(family1);
            user.setFamily(family1);
            userService.saveUser(user);
            return "redirect:/login";
        }
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("fake", new FakeUser());
        return "users/login";
    }

    @PostMapping("/login")
    public String logUser(@ModelAttribute FakeUser fake, Model model) {
        List<User> users = userService.showAllUsers();
        User logged = new User();
        for (User user1 : users) {
            if (fake.getName().equals((user1.getName()))) {
                if (BCrypt.checkpw(fake.getPassword(), user1.getPassword())) {
                    logged = user1;
                    model.addAttribute("logged", logged);
                    return "users/main";
                } else {
                    return "redirect:/login";
                }
            }

        }
        return "redirect:/login";
    }

}

//        @GetMapping("/main")
//    public String showMain(){
//        return
//        }
//    }




