package com.loja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loja.handler.UsuarioNaoExiste;
import com.loja.models.Usuario;
import com.loja.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository user;
	
	public List<Usuario> listarTodos() {
		return user.findAll();
	}
	
	public Usuario buscarId(Long id) {
		Optional<Usuario> usuarioId = user.findById(id);
		
		if (!usuarioId.isPresent()) {
			throw new UsuarioNaoExiste("Usuário não existe");
		}
		
		return usuarioId.get();
	}
	
	public Usuario salvar(Usuario usuario) {
		
		return user.save(usuario); 
	}
	
	public void atualizar(Usuario usuario) {
		verificaExistencia(usuario);
		
		user.save(usuario);
	}
	
	public void deletar(Long id) {
		try {
			user.deleteById(id);
		} catch (Exception e) {
			throw new UsuarioNaoExiste("Usuario não pode ser encontrado");
		}
	}
	
	private void verificaExistencia(Usuario usuario) {
		buscarId(usuario.getId());
	}
}
