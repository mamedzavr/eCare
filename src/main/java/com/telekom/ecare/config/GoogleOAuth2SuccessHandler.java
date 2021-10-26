package com.telekom.ecare.config;

import com.telekom.ecare.domain.Client;
import com.telekom.ecare.domain.Role;
import com.telekom.ecare.service.api.ClientService;
import com.telekom.ecare.service.api.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Component
public class GoogleOAuth2SuccessHandler implements AuthenticationSuccessHandler {
    private RoleService roleService;
    private ClientService clientService;

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    public GoogleOAuth2SuccessHandler(RoleService roleService, ClientService clientService) {
        this.roleService = roleService;
        this.clientService = clientService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;
        String email = token.getPrincipal().getAttributes().get("email").toString();
        if (clientService.getByEmail(email).isPresent()) {

        } else {
            Client client = new Client();
            client.setFirstName(token.getPrincipal().getAttributes().get("given_name").toString());
            client.setLastName(token.getPrincipal().getAttributes().get("family_name").toString());
            client.setEmail(email);
            Set<Role> roles = new HashSet<>();
            roles.add(roleService.getById(2L));
            client.setRoles(roles);
            clientService.create(client);
        }
        redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, "/home");
    }
}