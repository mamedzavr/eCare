package com.telekom.ecare.service.impl;

import com.telekom.ecare.domain.Client;
import com.telekom.ecare.domain.CustomClientDetails;
import com.telekom.ecare.service.api.ClientService;
import com.telekom.ecare.service.api.CustomClientDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomClientDetailsServiceImpl implements CustomClientDetailsService {
    @Autowired
    ClientService clientService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Client> client = clientService.getByEmail(email);
        client.orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return client.map(CustomClientDetails::new).get();
    }
}
