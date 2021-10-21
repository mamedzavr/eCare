package com.telekom.ecare.service.api;

import com.telekom.ecare.domain.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAll();

    Role getById(Long id);

    void create(Role role);

    void removeById(Long id);
}
