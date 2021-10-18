package com.telekom.ecare.service.impl;

import com.telekom.ecare.dao.OptionDao;
import com.telekom.ecare.domain.Option;
import com.telekom.ecare.service.api.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionServiceImpl implements OptionService {
    @Autowired
    private OptionDao optionDao;

    @Override
    public List<Option> getAll() {
        return optionDao.findAll();
    }

    @Override
    public Option getById(Long id) {
        return optionDao.findById(id).get();
    }

    @Override
    public void create(Option option) {
        optionDao.save(option);
    }

    @Override
    public void removeById(Long id) {
        optionDao.deleteById(id);
    }
}
