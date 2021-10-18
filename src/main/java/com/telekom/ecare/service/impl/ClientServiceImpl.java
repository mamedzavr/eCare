package com.telekom.ecare.service.impl;

import com.telekom.ecare.dao.ClientDao;
import com.telekom.ecare.domain.Client;
import com.telekom.ecare.service.api.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientDao clientDao;

    @Override
    public List<Client> getAll() {
        return clientDao.findAll();
    }

    @Override
    public Client getById(Long id) {
        return clientDao.findById(id).get();
    }

    @Override
    public Optional<Client> getByEmail(String email) {
        return clientDao.findClientByEmail(email);
    }

    @Override
    public void create(Client client) {
        clientDao.save(client);
    }

    @Override
    public void removeById(Long id) {
        clientDao.deleteById(id);
    }
}
