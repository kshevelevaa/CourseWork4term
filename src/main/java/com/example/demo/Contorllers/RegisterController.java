package com.example.demo.Contorllers;

import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class RegisterController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model){
        if (user.getPassword().length()<8){
            System.out.println("password error");
            return "register";
        }
        if (!user.getPassword().equals(user.getPasswordConfirm())){
            System.out.println("password confirm error");
            return "register";
        }
        if (userService.findUserByUsername(user.getUsername())!=null){
            System.out.println("user exist error");
            return "register";
        }
        try {
            userService.saveUser(user);
            return "redirect:/login";
        }
        catch(Exception e)
        {
            System.out.println("Abnormal error");
            return "register";

        }
    }
}
