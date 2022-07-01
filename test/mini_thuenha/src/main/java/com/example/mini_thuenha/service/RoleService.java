package com.example.mini_thuenha.service;


import com.example.mini_thuenha.model.Role;

public interface RoleService {
    Iterable<Role> findAll();


    void save(Role role);

    Role findByName(String name);
}
