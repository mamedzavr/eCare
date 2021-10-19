package com.telekom.ecare.service.implementation;

import com.telekom.ecare.dao.ClientDao;
import com.telekom.ecare.domain.Client;
import com.telekom.ecare.service.api.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {
    private ClientDao clientDao;

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
