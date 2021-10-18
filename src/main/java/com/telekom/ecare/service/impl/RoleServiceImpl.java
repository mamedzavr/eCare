package com.telekom.ecare.service.impl;

import com.telekom.ecare.dao.RoleDao;
import com.telekom.ecare.domain.Option;
import com.telekom.ecare.domain.Role;
import com.telekom.ecare.service.api.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDao roleDao;

    @Override
    public List<Role> getAll() {
        return roleDao.findAll();
    }

    @Override
    public Role getById(Long id) {
        return roleDao.findById(id).get();
    }

    @Override
    public void create(Role role) {
        roleDao.save(role);
    }

    @Override
    public void removeById(Long id) {
        roleDao.deleteById(id);
    }
}
