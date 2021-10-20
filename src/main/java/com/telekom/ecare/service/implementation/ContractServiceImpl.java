package com.telekom.ecare.service.implementation;

import com.telekom.ecare.dao.ContractDao;
import com.telekom.ecare.domain.Contract;
import com.telekom.ecare.service.api.ContractService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ContractServiceImpl implements ContractService {
    private ContractDao contractDao;

    @Override
    public List<Contract> getAll() {
        return contractDao.findAll();
    }

    @Override
    public Contract getById(Long id) {
        return contractDao.findById(id).get();
    }

    @Override
    public void create(Contract contract) {
        contractDao.save(contract);
    }

    @Override
    public void removeById(Long id) {
        contractDao.deleteById(id);
    }
}
