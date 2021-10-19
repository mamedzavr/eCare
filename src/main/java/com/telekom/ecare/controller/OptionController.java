package com.telekom.ecare.controller;

import com.telekom.ecare.domain.Option;
import com.telekom.ecare.service.api.OptionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class OptionController {
    private OptionService optionService;

    @GetMapping("/admin/options")
    public String getOptions(Model model) {
        model.addAttribute("options", optionService.getAll());
        return "options";
    }

    @GetMapping("/admin/options/add")
    public String getOptionAdd(Model model) {
        model.addAttribute("option", new Option());
        return "add-option";
    }

    @PostMapping("admin/options/add")
    public String postOptionAdd(@ModelAttribute("option") Option option) {
        optionService.create(option);
        return "redirect:/admin/options";
    }

    @GetMapping("/admin/options/delete/{id}")
    public String deleteOption(@PathVariable Long id) {
        optionService.removeById(id);
        return "redirect:/admin/options";
    }

    @GetMapping("/admin/options/update/{id}")
    public String updateOption(@PathVariable Long id, Model model) {
        Option option = optionService.getById(id);
        model.addAttribute("option", option);
        return "add-option";
    }
}
