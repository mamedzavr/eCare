package com.telekom.ecare.service.impl;

import com.telekom.ecare.dao.TariffDao;
import com.telekom.ecare.domain.Tariff;
import com.telekom.ecare.service.api.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TariffServiceImpl implements TariffService {
    @Autowired
    TariffDao tariffDao;

    @Override
    public List<Tariff> getAll() {
        return tariffDao.findAll();
    }

    @Override
    public Tariff getById(Long id) {
        return tariffDao.findById(id).get();
    }

    @Override
    public void create(Tariff tariff) {
        tariffDao.save(tariff);
    }

    @Override
    public void removeById(Long id) {
        tariffDao.deleteById(id);
    }
}
