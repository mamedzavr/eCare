package com.telekom.ecare.controller;

import com.telekom.ecare.domain.Tariff;
import com.telekom.ecare.service.api.OptionService;
import com.telekom.ecare.service.api.TariffService;
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
public class TariffController {
    private TariffService tariffService;
    private OptionService optionService;

    @GetMapping("/admin/tariffs")
    public String getTariffs(Model model) {
        model.addAttribute("tariffs", tariffService.getAll());
        return "tariffs";
    }

    @GetMapping("/admin/tariffs/add")
    public String getTariffAdd(Model model) {
        model.addAttribute("tariff", new Tariff());
        model.addAttribute("options", optionService.getAll());
        return "add-tariff";
    }

    @PostMapping("admin/tariffs/add")
    public String postTariffAdd(@ModelAttribute("tariff") Tariff tariff) {
        tariffService.create(tariff);
        return "redirect:/admin/tariffs";
    }

    @GetMapping("/admin/tariffs/delete/{id}")
    public String deleteTariff(@PathVariable Long id) {
        tariffService.removeById(id);
        return "redirect:/admin/tariffs";
    }

    @GetMapping("/admin/tariffs/update/{id}")
    public String updateTariff(@PathVariable Long id, Model model) {
        Tariff tariff = tariffService.getById(id);
        model.addAttribute("tariff", tariff);
        return "add-tariff";
    }
}
