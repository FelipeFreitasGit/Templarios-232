package com.loja.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.loja.models.DetalhesErro;

@ControllerAdvice
public class ResouceExceptionHandler {

	@ExceptionHandler(UsuarioNaoExiste.class)
	public ResponseEntity<DetalhesErro> handlerUsuarioNaoEncontradoException(UsuarioNaoExiste e,
			HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("Usuário não pôde ser encontrado");
		erro.setMensagemDesenvolvedor("http://erros.templarios.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
		
	}
	
	@ExceptionHandler(UsuarioRelacionadoNaoExiste.class)
	public ResponseEntity<DetalhesErro> handlerUsuarioRelacionadoNaoExisteException(UsuarioRelacionadoNaoExiste e,
			HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("Membro relacionado não existe");
		erro.setMensagemDesenvolvedor("http://erros.templarios.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
		
	}
	
	@ExceptionHandler(UsuarioExistenteException.class)
	public ResponseEntity<DetalhesErro> handlerNumeroExistenteException(UsuarioExistenteException e,
			HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(409l);
		erro.setTitulo("Número de cadastro de membro já existe.");
		erro.setMensagemDesenvolvedor("http://erros.templarios.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
		
	}
	
	
	@ExceptionHandler(UsuarioExistenteNaAniversario.class)
	public ResponseEntity<DetalhesErro> handlerUsuarioNaNIverExistenteException(UsuarioExistenteNaAniversario e,
			HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(409l);
		erro.setTitulo("Usuario esta relacionado com aniversáriante");
		erro.setMensagemDesenvolvedor("http://erros.templarios.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
		
	}
	
	@ExceptionHandler(EventoNaoExiste.class)
	public ResponseEntity<DetalhesErro> handlerEventoNaoEncontradoException(EventoNaoExiste e,
			HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("Evento não pôde ser encontrado");
		erro.setMensagemDesenvolvedor("http://erros.templarios.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
		
	}
	
}
