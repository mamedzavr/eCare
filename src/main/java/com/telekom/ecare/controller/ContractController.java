package com.telekom.ecare.controller;

import com.telekom.ecare.domain.Contract;
import com.telekom.ecare.domain.Option;
import com.telekom.ecare.domain.Tariff;
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

import java.util.Set;

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
        model.addAttribute("clients", clientService.getAll());
        return "add-contract";
    }

    @PostMapping("admin/contracts/add")
    public String postContractAdd(@ModelAttribute("contract") Contract contract) {
//        contract.setOptions(contract.getTariff().getOptions());
        contractService.create(contract);
        return "redirect:/admin/contracts";
    }

    @GetMapping("/admin/contracts/delete/{id}")
    public String deleteContract(@PathVariable Long id) {
        contractService.removeById(id);
        return "redirect:/admin/contracts";
    }

    @GetMapping("/admin/contracts/update/{contractId}")
    public String updateContract(@PathVariable Long contractId, Model model) {
//        System.out.println("id=" + contractId);
        Contract contract = contractService.getById(contractId);
//        System.out.println("contractid=" + contract.toString());
//        System.out.println("Contract = " + contract);
        model.addAttribute("contract", contract);
        model.addAttribute("options", contract.getOptions());
        model.addAttribute("tariffs", tariffService.getAll());
        model.addAttribute("clients", contract.getClient());
        return "add-contract";
    }

    @GetMapping("/admin/contracts/options/{id}")
    public String getContractOptions(@PathVariable Long id, Model model) {
        Contract contract = contractService.getById(id);
        model.addAttribute("contract", contract);
        model.addAttribute("options", optionService.getAll());
        System.out.println("get" + contract);
        return "add-contract-options";
    }

    @PostMapping("/admin/contracts/options/add")
    public String postContractOptions(@ModelAttribute("contract") Contract contract) {
        System.out.println("post" + contract);
        contractService.create(contract);
        return "redirect:/admin/contracts";
    }

    @GetMapping("/admin/contracts/options/add/{contractId}/{optionId}")
    public String addContractOption(@PathVariable Long contractId, @PathVariable Long optionId) {
        Contract contract = contractService.getById(contractId);
        Option option = optionService.getById(optionId);
        Set<Option> contractOptions = contract.getOptions();
        if (contractOptions.contains(option)) {
        } else {
            contractOptions.add(option);
            contract.setPrice(contract.getPrice() + option.getPrice());
            contractService.create(contract);
        }
        return "redirect:/admin/tariffs";
    }

    @GetMapping("/admin/contracts/options/delete/{contractId}/{optionId}")
    public String deleteContractOption(@PathVariable Long contractId, @PathVariable Long optionId) {
        Contract contract = contractService.getById(contractId);
        Option option = optionService.getById(optionId);
        Set<Option> contractOptions = contract.getOptions();
        if (contractOptions.contains(option)) {
            contract.getOptions().remove(option);
            contract.setPrice(contract.getPrice() - option.getPrice());
            contractService.create(contract);
        } else {
        }
        return "redirect:/admin/tariffs";
    }
}
