package com.example.mini_thuenha.repository;

import com.example.mini_thuenha.model.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHomeRepository extends JpaRepository<Home, Long> {
}
