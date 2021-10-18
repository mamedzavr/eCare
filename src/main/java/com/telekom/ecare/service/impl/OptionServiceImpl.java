package com.telekom.ecare.service.impl;

import com.telekom.ecare.dao.OptionDao;
import com.telekom.ecare.domain.Option;
import com.telekom.ecare.service.api.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OptionServiceImpl implements OptionService {
    @Autowired
    private OptionDao optionDao;

    @Override
    public List<Option> getAll() {
        return optionDao.findAll();
    }

    @Override
    public Optional<Option> getById(Long id) {
        return optionDao.findById(id);
    }
}
