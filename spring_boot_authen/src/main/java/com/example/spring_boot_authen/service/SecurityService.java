package com.example.spring_boot_authen.service;

public interface SecurityService {
    String findLonggedInUsername();
    void autoLogin(String username, String password);
}
