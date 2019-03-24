package pl.coderslab.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.User;
import pl.coderslab.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/app/users")


public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/main")
    public String showMain(){
        return "users/main";
    }


    @RequestMapping("/logout")
    public String logoutUser(HttpSession session){


            session.invalidate();
            return "redirect:/";
           }


@GetMapping("/edit")
    public String showEditForm(Model model, HttpSession session){
        User user = (User) session.getAttribute("logged");
        model.addAttribute("user", user);
        return "users/edit";
}

@RequestMapping("/edit")
    public String updateUser(@Valid User user, BindingResult result, HttpSession session){
    if(result.hasErrors()){
        return "users/edit";
    }else{

        userService.saveUser(user);
        session.setAttribute("logged", user);
    }
        return "redirect:/app/users/main";
}
}
