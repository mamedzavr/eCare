package com.telekom.ecare.service.implementation;

import com.telekom.ecare.dao.RoleDao;
import com.telekom.ecare.domain.Role;
import com.telekom.ecare.service.api.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    private RoleDao roleDao;

    @Override
    @Transactional
    public List<Role> getAll() {
        return roleDao.findAll();
    }

    @Override
    @Transactional
    public Role getById(Long id) {
        return roleDao.findById(id).get();
    }

    @Override
    @Transactional
    public void create(Role role) {
        roleDao.save(role);
    }

    @Override
    @Transactional
    public void removeById(Long id) {
        roleDao.deleteById(id);
    }
}
