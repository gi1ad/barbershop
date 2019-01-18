package com.gi1ad.barbershop.controller;


import com.gi1ad.barbershop.entity.News;
import com.gi1ad.barbershop.service.NewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    @Autowired
    NewsServiceImpl service;

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("news", new News());
        return "admin_page";
    }

    @PostMapping("/admin")
    public String createNews(News news){
        service.save(news);
        return "redirect/admin_page";
    }


}



