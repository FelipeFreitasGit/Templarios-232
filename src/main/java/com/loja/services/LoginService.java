package com.loja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.loja.handler.UsuarioLoginNaoExiste;
import com.loja.models.UsuarioLogin;
import com.loja.repository.LoginRepository;
import com.loja.security.UserSS;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository login;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	public List<UsuarioLogin> listarTodos() {
		return login.findAll();
	}
	
	public UsuarioLogin buscarId(Long id) {
		Optional<UsuarioLogin> usuarioLoginId = login.findById(id);
		
		if (!usuarioLoginId.isPresent()) {
			throw new UsuarioLoginNaoExiste("Usuario não pode ser encontrado");
		}
		
		return usuarioLoginId.get();
	}
	
	public UsuarioLogin salvar(UsuarioLogin usuarioLogin) {
		
		usuarioLogin.setSenha(bcrypt.encode(usuarioLogin.getSenha()));
		
		return login.save(usuarioLogin);
	}
	
	public void atualizar(UsuarioLogin usuarioLogin) {
		verificaExistencia(usuarioLogin);
		
		login.save(usuarioLogin);
	}
	
	public void deletar(Long id) {
		try {
			login.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new UsuarioLoginNaoExiste("Usuario não pode ser encontrado");
		}
	}

	private void verificaExistencia(UsuarioLogin usuarioLogin) {
		buscarId(usuarioLogin.getId());
	}
	
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}
}
