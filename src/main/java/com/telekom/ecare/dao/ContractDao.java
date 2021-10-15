package com.telekom.ecare.dao;

import com.telekom.ecare.domain.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractDao extends JpaRepository<Contract, Long> {
}
