package com.telekom.ecare.dao;

import com.telekom.ecare.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientDao extends JpaRepository<Client, Long> {
}
