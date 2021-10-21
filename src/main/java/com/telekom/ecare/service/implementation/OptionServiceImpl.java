package com.telekom.ecare.service.implementation;

import com.telekom.ecare.dao.OptionDao;
import com.telekom.ecare.domain.Option;
import com.telekom.ecare.service.api.OptionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class OptionServiceImpl implements OptionService {
    private OptionDao optionDao;

    @Override
    @Transactional
    public List<Option> getAll() {
        return optionDao.findAll();
    }

    @Override
    @Transactional
    public Option getById(Long id) {
        return optionDao.findById(id).get();
    }

    @Override
    @Transactional
    public void create(Option option) {
        optionDao.save(option);
    }

    @Override
    @Transactional
    public void removeById(Long id) {
        optionDao.deleteById(id);
    }
}
