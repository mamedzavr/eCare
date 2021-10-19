package com.telekom.ecare.service.implementation;

import com.telekom.ecare.domain.Client;
import com.telekom.ecare.domain.CustomClientDetails;
import com.telekom.ecare.service.api.ClientService;
import com.telekom.ecare.service.api.CustomClientDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomClientDetailsServiceImpl implements CustomClientDetailsService {
    private ClientService clientService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Client> client = clientService.getByEmail(email);
        client.orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return client.map(CustomClientDetails::new).get();
    }
}
