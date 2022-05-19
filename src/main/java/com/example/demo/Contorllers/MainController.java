package com.example.demo.Contorllers;

import com.example.demo.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/index")
    public String showIndex()
    {
        return "index";
    }

    @GetMapping("/login")
    public String showLogin()
    {
        return "login";
    }

    @GetMapping("/register")
    public String showRegister(Model model)
    {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @GetMapping("/about")
    public String showOffer()
    {
        return "about";
    }

}
