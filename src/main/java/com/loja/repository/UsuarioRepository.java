package com.loja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loja.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Usuario findByNumCadMemb(Long numCadMemb);
	
	List<Usuario> findByEmail1StartingWith(String email1);
}
