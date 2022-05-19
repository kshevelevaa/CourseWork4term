package com.example.demo.Contorllers;

import com.example.demo.Entity.User;
import com.example.demo.Service.DressService;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {
    @Autowired
    private UserService userService;
    @Autowired
    private DressService dressService;


    @GetMapping("/wishlist")
    public String showCart(Model model) {
        try {
            User userAuth = userService.getUserAuth();
            model.addAttribute("dresses", userAuth.getList());
        } catch (Exception e) {

        }
        return "wishlist";
    }

    @GetMapping("clear")
    public String clearCart() {
        User userAuth = userService.getUserAuth();
        dressService.deleteDresses(userAuth.getList());
        userAuth.getList().clear();
        return "wishlist";
    }

    @GetMapping("/order")
    public String GetOrder(Model model) {
        model.addAttribute("infoSetting", true);

        model.addAttribute("message", "Order created successfully");
        User userAuth = userService.getUserAuth();
        String price = userAuth.getOrderPrice();
        dressService.deleteDresses(userAuth.getList());
        userAuth.getList().clear();
        return "wishlist";
    }

}
