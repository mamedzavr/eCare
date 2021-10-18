package com.telekom.ecare.dao;

import com.telekom.ecare.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientDao extends JpaRepository<Client, Long> {
    Optional<Client> findClientByEmail(String email);
}
