package com.gi1ad.barbershop.controller;

import com.gi1ad.barbershop.service.PricesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PriceController {

    @Autowired
    PricesServiceImpl pricesService;

    @GetMapping("/price")
    public String getPrices(Model model){
        model.addAttribute("prices",pricesService.getAll());
        return "price_page";
    }

}
