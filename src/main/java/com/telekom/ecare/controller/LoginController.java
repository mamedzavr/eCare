package com.telekom.ecare.controller;

import com.telekom.ecare.dao.RoleDao;
import com.telekom.ecare.domain.Client;
import com.telekom.ecare.domain.Role;
import com.telekom.ecare.service.api.ClientService;
import com.telekom.ecare.service.api.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;

@Controller
@AllArgsConstructor
public class LoginController {
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private ClientService clientService;
    private RoleService roleService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String getRegister(Model model) {
        model.addAttribute("client", new Client());
        return "register";
    }

    @PostMapping("/register")
    public String postRegister(
            @ModelAttribute("client") Client client,
            HttpServletRequest request
    ) throws ServletException {
        String password = client.getPassword();
        client.setPassword(bCryptPasswordEncoder.encode(password));
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.getById(2L));
        client.setRoles(roles);
        clientService.create(client);
        request.login(client.getEmail(), password);
        return "redirect:/";
    }
}
