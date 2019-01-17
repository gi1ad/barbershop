package com.gi1ad.barbershop.controller;


import com.gi1ad.barbershop.entity.News;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @RequestMapping("/admin")
    public String admin(Model model){
        model.addAttribute("news", new News());
        return "admin_page";
    }


}
