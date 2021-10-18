package com.telekom.ecare.service.api;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface CustomClientDetailsService extends UserDetailsService {
    public UserDetails loadUserByUsername(String email);
}
