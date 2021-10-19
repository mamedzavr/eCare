package com.telekom.ecare.service.api;

import com.telekom.ecare.domain.Option;
import com.telekom.ecare.domain.Role;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RoleService {
    List<Role> getAll();

    Role getById(Long id);

    void create(Role role);

    void removeById(Long id);
}
