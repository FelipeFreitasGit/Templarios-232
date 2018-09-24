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

import com.loja.models.Evento;
import com.loja.services.EventosService;

@RestController
@RequestMapping("/evento")
public class EventoController {
	
	@Autowired
	private EventosService eventos;
	
	@GetMapping
	public ResponseEntity<List<Evento>> listar() {

		return ResponseEntity.status(HttpStatus.OK).body(eventos.listarTodos());
	}
	
	@PostMapping
	@PreAuthorize("hasAnyRole('ADMINISTRADOR')")
	public ResponseEntity<Evento> cadastrar(@Valid @RequestBody Evento evento) {
		Evento eventoSalvo = eventos.salvar(evento);

		return ResponseEntity.status(HttpStatus.CREATED).body(eventoSalvo);
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasAnyRole('ADMINISTRADOR')")
	public ResponseEntity<?> atualizar(@Valid @PathVariable("id") Long id, @RequestBody Evento evento) {

		try {
			
			evento.setId(id);
			eventos.atualizar(evento);
			
			return ResponseEntity.ok("Evento alterado com sucesso.");
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAnyRole('ADMINISTRADOR')")
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		eventos.deletar(id);

		return ResponseEntity.noContent().build();
	}
}