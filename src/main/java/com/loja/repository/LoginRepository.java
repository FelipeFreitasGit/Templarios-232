package com.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loja.models.UsuarioLogin;
import org.springframework.transaction.annotation.Transactional;

public interface LoginRepository extends JpaRepository<UsuarioLogin, Long>{
	
	@Transactional(readOnly=true)
	UsuarioLogin findByNivelLogin(String nivel);
}
