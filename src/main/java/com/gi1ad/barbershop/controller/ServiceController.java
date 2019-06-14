package com.gi1ad.barbershop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServiceController {

    @GetMapping("/service")
    public String getServices(){
        return "service_page";
    }
}
