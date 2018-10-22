package com.rentaroom.security.role.repository;

import com.rentaroom.security.role.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

}