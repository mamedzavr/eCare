package com.telekom.ecare.service.implementation;

import com.telekom.ecare.dao.ContractDao;
import com.telekom.ecare.domain.Contract;
import com.telekom.ecare.service.api.ContractService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ContractServiceImpl implements ContractService {
    private ContractDao contractDao;

    @Override
    @Transactional
    public List<Contract> getAll() {
        return contractDao.findAll();
    }

    @Override
    @Transactional
    public Contract getById(Long id) {
        return contractDao.findById(id).get();
    }

    @Override
    @Transactional
    public void create(Contract contract) {
        contractDao.save(contract);
    }

    @Override
    @Transactional
    public void removeById(Long id) {
        contractDao.deleteById(id);
    }
}
