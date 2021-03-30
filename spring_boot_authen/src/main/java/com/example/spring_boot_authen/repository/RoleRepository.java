package com.example.spring_boot_authen.repository;

import com.example.spring_boot_authen.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
