package com.gi1ad.barbershop.controller;


import com.gi1ad.barbershop.entity.News;
import com.gi1ad.barbershop.entity.Prices;
import com.gi1ad.barbershop.service.NewsServiceImpl;
import com.gi1ad.barbershop.service.PricesService;
import com.gi1ad.barbershop.service.PricesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/images")
public class ImageController {

    @Autowired
    NewsServiceImpl service;

    @Autowired
    PricesServiceImpl pricesService;

    @RequestMapping("/{id}")
    public void getImage(@PathVariable long id, HttpServletResponse response) {
        response.setContentType("image/png");
        News news = service.getById(id);
        if (news != null) {
            try {
                response.getOutputStream().write(news.getNewsImage());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @GetMapping("/prices/{id}")
    public void getPrice(@PathVariable long id, HttpServletResponse response){
        response.setContentType("image/png");
        Prices prices = pricesService.getById(id);
        if (prices != null){
            try {
                response.getOutputStream().write(prices.getPriceImage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
