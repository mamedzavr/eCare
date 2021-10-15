package com.telekom.ecare.dao;

import com.telekom.ecare.domain.Tariff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TariffDao extends JpaRepository<Tariff, Long> {
}
