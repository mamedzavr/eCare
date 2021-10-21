package com.telekom.ecare.service.implementation;

import com.telekom.ecare.dao.ClientDao;
import com.telekom.ecare.domain.Client;
import com.telekom.ecare.service.api.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {
    private ClientDao clientDao;

    @Override
    @Transactional
    public List<Client> getAll() {
        return clientDao.findAll();
    }

    @Override
    @Transactional
    public Client getById(Long id) {
        return clientDao.findById(id).get();
    }

    @Override
    @Transactional
    public Optional<Client> getByEmail(String email) {
        return clientDao.findClientByEmail(email);
    }

    @Override
    @Transactional
    public void create(Client client) {
        clientDao.save(client);
    }

    @Override
    @Transactional
    public void removeById(Long id) {
        clientDao.deleteById(id);
    }
}
