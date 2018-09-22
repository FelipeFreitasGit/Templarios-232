package com.loja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.loja.handler.UsuarioNaoExiste;
import com.loja.handler.UsuarioRelacionadoNaoExiste;
import com.loja.models.Aniversariante;
import com.loja.repository.AniversarianteRepository;

@Service
public class AniversarianteService {

	@Autowired
	private AniversarianteRepository niver;
	
	public List<Aniversariante> listarTodos() {
		return niver.findAll();
	}
	
	public Aniversariante buscarId(Long id) {
		Optional<Aniversariante> usuarioId = niver.findById(id);
		
		if (!usuarioId.isPresent()) {
			throw new UsuarioNaoExiste("Usuário não existe");
		}
		
		return usuarioId.get();
	}
	
	public Aniversariante salvar(Aniversariante usuario) {
		
		try {
			return niver.save(usuario); 
		} catch (DataIntegrityViolationException e) {
			throw new UsuarioRelacionadoNaoExiste("Membro relacionado não existe");
		}
	}
	
	public void atualizar(Aniversariante usuario) {
		verificaExistencia(usuario);
		
		niver.save(usuario);
	}
	
	public void deletar(Long id) {
		try {
			niver.deleteById(id);
		} catch (Exception e) {
			throw new UsuarioNaoExiste("Usuario não pode ser encontrado");
		}
	}
	
	private void verificaExistencia(Aniversariante usuario) {
		buscarId(usuario.getId());
	}
}
