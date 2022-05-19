package com.example.demo.Contorllers;

import com.example.demo.Entity.User;
import com.example.demo.Service.DressService;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DressController {
    @Autowired
    private DressService dressService;
    @Autowired
    private UserService userService;

    @GetMapping("/add_dress_{number}")
    public String addDressWithNumber(@PathVariable int number) {
        User userAuth = userService.getUserAuth();
        dressService.plusCountDress(userAuth, number);
        return "redirect:/index#{number}";
    }

    @GetMapping("/remove_dress_{number}")
    public String removeDressWithNumber(@PathVariable int number) {
        User userAuth = userService.getUserAuth();
        dressService.minusCountDress(userAuth, number);
        return "redirect:/index#{number}";
    }

}
