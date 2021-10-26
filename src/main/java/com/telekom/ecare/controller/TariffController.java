package com.telekom.ecare.controller;

import com.telekom.ecare.domain.Option;
import com.telekom.ecare.domain.Tariff;
import com.telekom.ecare.service.api.OptionService;
import com.telekom.ecare.service.api.TariffService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Set;


@Controller
@AllArgsConstructor
public class TariffController {
    TariffService tariffService;
    OptionService optionService;

    @GetMapping("/admin/tariffs")
    public String getTariffs(Model model) {
        model.addAttribute("tariffs", tariffService.getAll());
        return "tariffs";
    }

    @GetMapping("/admin/tariffs/add")
    public String getTariffAdd(Model model) {
        model.addAttribute("tariff", new Tariff());
        return "add-tariff";
    }

    @PostMapping("admin/tariffs/add")
    public String postTariffAdd(@ModelAttribute("tariff") Tariff tariff) {
        if (tariff.getId() == null) {
            tariffService.create(tariff);
        } else {
            Tariff newTariff = new Tariff(tariffService.getById(tariff.getId()));
            newTariff.setName(tariff.getName());
            tariffService.create(newTariff);
        }
        return "redirect:/admin/tariffs";
    }

    @GetMapping("/admin/tariffs/delete/{tariffId}")
    public String deleteTariff(@PathVariable Long tariffId) {
        tariffService.removeById(tariffId);
        return "redirect:/admin/tariffs";
    }

    @GetMapping("/admin/tariffs/update/{tariffId}")
    public String updateTariff(@PathVariable Long tariffId, Model model) {
        Tariff tariff = tariffService.getById(tariffId);
        model.addAttribute("tariff", tariff);
        return "add-tariff";
    }

    @GetMapping("/admin/tariffs/options/{tariffId}")
    public String showTariffOptions(@PathVariable Long tariffId, Model model) {
        model.addAttribute("tariff", tariffService.getById(tariffId));
        model.addAttribute("options", optionService.getAll());
        return "add-tariff-options";
    }

    @GetMapping("/admin/tariffs/options/add/{tariffId}/{optionId}")
    public String addTariffOption(@PathVariable Long tariffId, @PathVariable Long optionId) {
        Tariff tariff = tariffService.getById(tariffId);
        Option option = optionService.getById(optionId);
        Set<Option> tariffOptions = tariff.getOptions();
        if (tariffOptions.contains(option)) {
        } else {
            tariffOptions.add(option);
            tariff.setPrice(tariff.getPrice() + option.getPrice());
            tariffService.create(tariff);
        }
        return "redirect:/admin/tariffs";
    }

    @GetMapping("/admin/tariffs/options/delete/{tariffId}/{optionId}")
    public String deleteTariffOption(@PathVariable Long tariffId, @PathVariable Long optionId) {
        Tariff tariff = tariffService.getById(tariffId);
        Option option = optionService.getById(optionId);
        Set<Option> tariffOptions = tariff.getOptions();
        if (tariffOptions.contains(option)) {
            tariff.getOptions().remove(option);
            tariff.setPrice(tariff.getPrice() - option.getPrice());
            tariffService.create(tariff);
        } else {
        }
        return "redirect:/admin/tariffs";
    }
}
