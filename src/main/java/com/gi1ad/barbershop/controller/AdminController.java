package com.gi1ad.barbershop.controller;


import com.gi1ad.barbershop.entity.News;
import com.gi1ad.barbershop.service.NewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    NewsServiceImpl service;

    @GetMapping("/index")
    public String admin(Model model) {
        model.addAttribute("news", new News());
        return "admin_page";
    }

    @PostMapping("/save")
    public String createNews(News news) {
        service.save(news);
        return "redirect:" + "/admin";
    }

    @GetMapping("/content")
    public String getContent(Model model){
        model.addAttribute("news",service.getAll());
        return "content_page";
    }

    @PostMapping("/content/delete")
    public String deleteContent(@PathVariable long id){
        service.remove(id);
        return "redirect:" + "/content";
    }
    @InitBinder
    public static void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws ServletException {
        binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
        }


}



