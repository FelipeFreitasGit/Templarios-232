package com.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loja.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
}
