package com.telekom.ecare.controller;

import com.telekom.ecare.domain.Client;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping({"/", "/home", "/index"})
    public String home() {
        Client client = new Client();
        return "index";
    }
}
