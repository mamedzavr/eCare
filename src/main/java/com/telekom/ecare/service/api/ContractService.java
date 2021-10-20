package com.telekom.ecare.service.api;

import com.telekom.ecare.domain.Contract;
import com.telekom.ecare.domain.Option;

import java.util.List;

public interface ContractService {
    List<Contract> getAll();

    Contract getById(Long id);

    void create(Contract contract);

    void removeById(Long id);
}
