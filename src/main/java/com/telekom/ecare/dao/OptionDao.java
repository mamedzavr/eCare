package com.telekom.ecare.dao;

import com.telekom.ecare.domain.Option;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OptionDao extends JpaRepository<Option, Long> {

}
