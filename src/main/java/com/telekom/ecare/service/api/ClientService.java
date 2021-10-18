package com.telekom.ecare.service.api;

import com.telekom.ecare.domain.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    List<Client> getAll();

    Client getById(Long id);

    Optional<Client> getByEmail(String email);

    void create(Client client);

    void removeById(Long id);
}
