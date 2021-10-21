package com.telekom.ecare.service.implementation;

import com.telekom.ecare.dao.TariffDao;
import com.telekom.ecare.domain.Tariff;
import com.telekom.ecare.service.api.TariffService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class TariffServiceImpl implements TariffService {
    private TariffDao tariffDao;

    @Override
    @Transactional
    public List<Tariff> getAll() {
        return tariffDao.findAll();
    }

    @Override
    @Transactional
    public Tariff getById(Long id) {
        return tariffDao.findById(id).get();
    }

    @Override
    @Transactional
    public void create(Tariff tariff) {
        tariffDao.save(tariff);
    }

    @Override
    @Transactional
    public void removeById(Long id) {
        tariffDao.deleteById(id);
    }
}
