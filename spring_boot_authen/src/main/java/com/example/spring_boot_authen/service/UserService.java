package com.example.spring_boot_authen.service;

import com.example.spring_boot_authen.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService  {
    void save(User user);
    User findByUsername(String username);
}
