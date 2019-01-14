package com.gi1ad.barbershop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {
    @RequestMapping("/403")
    public String error(){
        return "error403_page";
    }
}
