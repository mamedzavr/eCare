package com.telekom.ecare.service.api;

import com.telekom.ecare.domain.Option;

import java.util.List;
import java.util.Optional;

public interface OptionService {
    List<Option> getAll();

    Optional<Option> getById(Long id);
}
