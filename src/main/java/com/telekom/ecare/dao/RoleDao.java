package com.telekom.ecare.dao;

import com.telekom.ecare.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {
}
