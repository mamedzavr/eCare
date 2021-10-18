package com.telekom.ecare.controller;

import com.telekom.ecare.dao.OptionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OptionController {
    @Autowired
    OptionDao optionDao;

    @GetMapping("/admin/options")
    public String getOptions() {


        return "gallery";
    }
}
