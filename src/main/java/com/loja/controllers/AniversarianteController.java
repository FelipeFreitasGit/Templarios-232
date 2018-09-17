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

import com.loja.models.Aniversariante;
import com.loja.services.AniversarianteService;

@RestController
@RequestMapping("/aniversariante")
public class AniversarianteController {
	
	@Autowired
	private AniversarianteService niver;
	

	@GetMapping
	public ResponseEntity<List<Aniversariante>> listar() {
		
		return ResponseEntity.status(HttpStatus.OK).body(niver.listarTodos());
	}
	
	@PostMapping
	@PreAuthorize("hasAnyRole('ADMINISTRADOR')")
	public ResponseEntity<Aniversariante> cadastrar(@Valid @RequestBody Aniversariante usuario) {
		Aniversariante usuarioSalvo = niver.salvar(usuario);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasAnyRole('ADMINISTRADOR')")
	public ResponseEntity<Void> atualizar(@PathVariable("id") Long id, @RequestBody Aniversariante usuario) {
		
		usuario.setId(id);
		niver.atualizar(usuario);
		
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAnyRole('ADMINISTRADOR')")
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		niver.deletar(id);
		
		return ResponseEntity.noContent().build();
	}
}
