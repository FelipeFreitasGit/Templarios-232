package com.loja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loja.models.Usuario;
import com.loja.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService user;

	@GetMapping
	public ResponseEntity<List<Usuario>> listar() {

		return ResponseEntity.status(HttpStatus.OK).body(user.listarTodos());
	}

	@PostMapping
	@PreAuthorize("hasAnyRole('ADMINISTRADOR')")
	public ResponseEntity<Usuario> cadastrar(@Valid @RequestBody Usuario usuario) {
		Usuario usuarioSalvo = user.salvar(usuario);

		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasAnyRole('ADMINISTRADOR')")
	public ResponseEntity<?> atualizar(@Valid @PathVariable("id") Long id, @RequestBody Usuario usuario) {

		try {
			
			usuario.setId(id);
			user.atualizar(usuario);
			
			return ResponseEntity.ok("Usuário alterado com sucesso.");
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasAnyRole('ADMINISTRADOR')")
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		user.deletar(id);

		return ResponseEntity.noContent().build();
	}
}
