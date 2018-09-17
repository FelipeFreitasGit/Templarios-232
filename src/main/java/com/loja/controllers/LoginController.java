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

import com.loja.models.UsuarioLogin;
import com.loja.services.LoginService;

@RestController
@RequestMapping("/userLogin")
public class LoginController {

	@Autowired
	private LoginService login;
	
	@PostMapping
	public ResponseEntity<UsuarioLogin> cadastrar(@Valid @RequestBody UsuarioLogin usuarioLogin) {
		UsuarioLogin usuarioLoginSalvo = login.salvar(usuarioLogin);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioLoginSalvo);
	}
	
	@GetMapping
	@PreAuthorize("hasAnyRole('ADMINISTRADOR')")
	public ResponseEntity<List<UsuarioLogin>> listar() {
		
		return ResponseEntity.status(HttpStatus.OK).body(login.listarTodos());
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasAnyRole('ADMINISTRADOR')")
	public ResponseEntity<Void> atualizar(@PathVariable("id") Long id, @RequestBody UsuarioLogin usuarioLogin) {
		
		usuarioLogin.setId(id);
		login.atualizar(usuarioLogin);
		
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAnyRole('ADMINISTRADOR')")
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		login.deletar(id);
		
		return ResponseEntity.noContent().build();
	}
}
