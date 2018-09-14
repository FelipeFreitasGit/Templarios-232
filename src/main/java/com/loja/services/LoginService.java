package com.loja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.loja.handler.UsuarioLoginNaoExiste;
import com.loja.models.UsuarioLogin;
import com.loja.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository login;
	
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
}
