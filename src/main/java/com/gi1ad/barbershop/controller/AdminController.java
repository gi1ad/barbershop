package com.gi1ad.barbershop.controller;


import com.gi1ad.barbershop.entity.News;
import com.gi1ad.barbershop.service.NewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

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
    public String createNews(News news) {
        service.save(news);
        return "redirect:" + "/admin";
    }

    @GetMapping("/content")
    public String getContent(Model model){
        model.addAttribute("news",service.getAll());
        return "content_page";
    }


    @InitBinder
    public static void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws ServletException {
        binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
        }


}



