package com.telekom.ecare.service.api;

import com.telekom.ecare.domain.Tariff;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TariffService {
    List<Tariff> getAll();

    Tariff getById(Long id);

    void create(Tariff tariff);

    void removeById(Long id);
}
