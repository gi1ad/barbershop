package com.gi1ad.barbershop.controller;


import com.gi1ad.barbershop.service.NewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewsController {

    @Autowired
    NewsServiceImpl service;

   @GetMapping("/news")
    public String getNews(Model model){
        model.addAttribute("news",service.getAll());
        return "news_page";
    }

}
