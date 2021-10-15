package com.telekom.ecare.dao;

import com.telekom.ecare.domain.Option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionDao extends JpaRepository<Option, Long> {
}
