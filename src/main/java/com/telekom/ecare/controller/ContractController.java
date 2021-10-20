package com.telekom.ecare.controller;

import com.telekom.ecare.domain.Contract;
import com.telekom.ecare.domain.Option;
import com.telekom.ecare.service.api.ClientService;
import com.telekom.ecare.service.api.ContractService;
import com.telekom.ecare.service.api.OptionService;
import com.telekom.ecare.service.api.TariffService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class ContractController {

    private OptionService optionService;
    private TariffService tariffService;
    private ClientService clientService;
    private ContractService contractService;

    @GetMapping("/admin/contracts")
    public String getContracts(Model model) {
        model.addAttribute("contracts", contractService.getAll());
        return "contracts";
    }

    @GetMapping("/admin/contracts/add")
    public String getContractAdd(Model model) {
        model.addAttribute("contract", new Contract());
        model.addAttribute("options", optionService.getAll());
        model.addAttribute("tariffs", tariffService.getAll());
        return "add-contract";
    }

    @PostMapping("admin/contracts/add")
    public String postContractAdd(@ModelAttribute("contract") Contract contract) {
        contractService.create(contract);
        return "redirect:/admin/contracts";
    }
//
//    @GetMapping("/admin/options/delete/{id}")
//    public String deleteOption(@PathVariable Long id) {
//        optionService.removeById(id);
//        return "redirect:/admin/options";
//    }
//
//    @GetMapping("/admin/options/update/{id}")
//    public String updateOption(@PathVariable Long id, Model model) {
//        Option option = optionService.getById(id);
//        model.addAttribute("option", option);
//        return "add-option";
//    }
}
