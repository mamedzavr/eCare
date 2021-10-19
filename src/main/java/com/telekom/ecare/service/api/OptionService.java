package com.telekom.ecare.service.api;

import com.telekom.ecare.domain.Option;

import java.util.List;
import java.util.Set;

public interface OptionService {
    List<Option> getAll();

    Option getById(Long id);

    void create(Option option);

    void removeById(Long id);
}
