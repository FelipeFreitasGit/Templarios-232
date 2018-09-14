package com.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loja.models.UsuarioLogin;

public interface LoginRepository extends JpaRepository<UsuarioLogin, Long>{

}
