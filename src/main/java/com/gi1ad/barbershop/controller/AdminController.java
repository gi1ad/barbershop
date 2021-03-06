package com.gi1ad.barbershop.controller;


import com.gi1ad.barbershop.entity.News;
import com.gi1ad.barbershop.entity.Prices;
import com.gi1ad.barbershop.service.NewsServiceImpl;
import com.gi1ad.barbershop.service.PricesServiceImpl;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Pageable;
import java.io.IOException;
import java.sql.SQLException;

@Controller
public class AdminController {

    @Autowired
    NewsServiceImpl service;

    @Autowired
    PricesServiceImpl pricesService;

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("news", new News());
        return "admin_page";
    }

    @PostMapping("admin/save")
    public String createNews(News news) {
        service.save(news);
        return "redirect:" + "/admin";
    }

    @GetMapping("/content")
    public String getContent(Model model) {
        model.addAttribute("news", service.findAll());
        return "content_page";
    }

    @PostMapping("/content/delete")
    public void deleteContent(@RequestParam long id, HttpServletResponse response) {
        service.remove(id);
        try {
            response.sendRedirect("/content");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/prices")
    public String addPrices(Model model) {
        model.addAttribute("prices", new Prices());
        return "prices_page";
    }

    @PostMapping("prices/save")
    public String savePrice(Prices prices) {
        pricesService.save(prices);
        return "redirect:" + "/prices";
    }


    @GetMapping("/price-list")
    public String getPricesList(Model model) {
        model.addAttribute("prices", pricesService.getAll());
        return "price_list_page";
    }

    @PostMapping("/price-list/delete")
    public void deletePrice(@RequestParam long id, HttpServletResponse response) {
        pricesService.remove(id);
        try {
            response.sendRedirect("/price-list");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @InitBinder
    public static void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws ServletException {
        binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
    }


}



